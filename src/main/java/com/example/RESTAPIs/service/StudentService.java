package com.example.RESTAPIs.service;

import java.util.List;
import java.util.Map;

import com.example.RESTAPIs.dto.AddStudentRequestDto;
import com.example.RESTAPIs.dto.StudentDto;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updatestudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
