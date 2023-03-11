package com.elearning.service;

import com.elearning.entity.Student;
import com.elearning.exception.StudentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> retrieveAllStudents();


    Student findById(Long id) throws StudentNotFoundException;

    Student updateStudent(Student student,Long id);

    void deleteStudentById(Long id);
}
