package com.elearning.service;

import com.elearning.entity.Course;
import com.elearning.entity.Enrollment;
import com.elearning.entity.Student;
import com.elearning.repository.CourseRepository;
import com.elearning.repository.EnrollmentRepo;
import com.elearning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void setCoursesAndStudents(Long courseId, Long studentId) {
        Course coursedb = courseRepository.findById(courseId).get();
        Student studentdb = studentRepository.findById(studentId).get();
        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(coursedb);
        enrollment.setStudent(studentdb);
        enrollmentRepo.save(enrollment);
    }
}
