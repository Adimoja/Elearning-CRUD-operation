package com.elearning.service;

import com.elearning.entity.Student;
import com.elearning.exception.StudentNotFoundException;
import com.elearning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) throws StudentNotFoundException {
       Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()){
            throw new StudentNotFoundException("Student Not Found");
        }
        return student.get();
    }

    @Override
    public Student updateStudent(Student student,Long id) {
        Student studentdb = studentRepository.findById(id).get();
        if(Objects.nonNull(student.getStudentFirstName()) &&
                !"".equalsIgnoreCase(student.getStudentFirstName())){
            studentdb.setStudentFirstName(student.getStudentFirstName());
        }
        if(Objects.nonNull(student.getStudentLastName()) &&
        !"".equalsIgnoreCase(student.getStudentLastName())){
            studentdb.setStudentLastName(student.getStudentLastName());
        }
        if(Objects.nonNull(student.getEmail()) &&
        !"".equalsIgnoreCase(student.getEmail())){
            studentdb.setEmail(student.getEmail());
        }

        return studentRepository.save(studentdb);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}
