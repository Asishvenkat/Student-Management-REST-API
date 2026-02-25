package com.example.RESTAPIs.service.impl;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.RESTAPIs.dto.AddStudentRequestDto;
import com.example.RESTAPIs.dto.StudentDto;
import com.example.RESTAPIs.entity.Student;
import com.example.RESTAPIs.service.StudentService;

import lombok.RequiredArgsConstructor;
import com.example.RESTAPIs.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentServiceimpl implements StudentService {
    
   private final StudentRepository studentRepository;
   private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students= studentRepository.findAll();
        return students
                       .stream()
                       .map(student->modelMapper.map(student, StudentDto.class))
                       .toList();
    }

    @Override
    public StudentDto getStudentById(Long id){
        Student student= studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with ID:"+id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student student = modelMapper.map(addStudentRequestDto, Student.class);
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id){
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found with ID:"+id);
        } else {
            studentRepository.deleteById(id);
        }
    }

    @Override 
    public StudentDto updatestudent(Long id, AddStudentRequestDto addStudentRequestDto){
       Student student = studentRepository.findById(id)
                 .orElseThrow(() -> new IllegalArgumentException("Student not found with Id: "+id));
       modelMapper.map(addStudentRequestDto, student);
       
       student = studentRepository.save(student);
       return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id,Map<String, Object> updates){
       Student student = studentRepository.findById(id)
                 .orElseThrow(() -> new IllegalArgumentException("Student not found with Id: "+id));
       updates.forEach((field,value)->{
          switch(field){
                case "name":
                    student.setName((String)value);
                    break;
                case "email":
                    student.setEmail((String)value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: "+field);
          }
       });
       Student savedStudent = studentRepository.save(student);
       return modelMapper.map(savedStudent, StudentDto.class);

    }

}
