
package com.example.RESTAPIs.controller;

import com.example.RESTAPIs.dto.AddStudentRequestDto;
import com.example.RESTAPIs.dto.StudentDto;
import com.example.RESTAPIs.entity.Student;
import com.example.RESTAPIs.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
 
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudent(){
          return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto AddStudentRequestDto){
      return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(AddStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updatestudent(@PathVariable Long id, @RequestBody AddStudentRequestDto addStudentRequestDto){
    
        return ResponseEntity.ok(studentService.updatestudent(id, addStudentRequestDto));
    } 
    
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> partiallyUpdateStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        
        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }

   
 
}


