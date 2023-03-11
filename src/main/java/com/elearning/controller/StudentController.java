package com.elearning.controller;

import com.elearning.entity.Student;
import com.elearning.exception.StudentNotFoundException;
import com.elearning.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "students")
    public Student createStudent(@Valid@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping(path = "students")
    public List<Student> retrieveAllStudents() {
      return studentService.retrieveAllStudents();
    }

    @GetMapping("students/{id}")
    public Student findById(@PathVariable Long id) throws StudentNotFoundException
    {
        return studentService.findById(id);
    }
    @PutMapping("students/update/{id}")
    public Student updateStudent(@Valid @RequestBody Student student, @PathVariable("id") Long id){
        return studentService.updateStudent(student,id);
    }

    @DeleteMapping("students/delete/{id}")
    public void deleteStudentById(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);
    }
    }

