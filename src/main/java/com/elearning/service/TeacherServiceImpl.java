package com.elearning.service;

import com.elearning.entity.Course;
import com.elearning.entity.Teacher;
import com.elearning.repository.CourseRepository;
import com.elearning.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeachersRepository teachersRepository;

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Teacher addTeacher(Teacher teacher) {

        return teachersRepository.save(teacher) ;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teachersRepository.findAll();
    }

    @Override
    public Teacher setTeacherToCourse(Long teacherID, Long courseID) {
        Teacher teacherdb = teachersRepository.findById(teacherID).get();
        Course coursedb = courseRepository.findById(courseID).get();
        teacherdb.getCourses().add(coursedb);

        return teachersRepository.save(teacherdb);
    }
}
