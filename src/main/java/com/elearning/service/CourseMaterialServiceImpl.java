package com.elearning.service;

import com.elearning.entity.Course;
import com.elearning.entity.CourseMaterial;
import com.elearning.repository.CourseMaterialRepository;
import com.elearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMaterialServiceImpl implements CourseMaterialService{
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public CourseMaterial addCourseMaterial(CourseMaterial courseMaterial) {
        return courseMaterialRepository.save(courseMaterial);
    }

    @Override
    public List<CourseMaterial> getAllcourseMaterial() {
        return courseMaterialRepository.findAll();
    }

    @Override
    public CourseMaterial addExistingCourse(Long id,Long idCourse) {
        CourseMaterial courseMaterialdb = courseMaterialRepository.findById(id).get();
        Course course = courseRepository.findById(idCourse).get();
        courseMaterialdb.setCourse(course);
        return courseMaterialRepository.save(courseMaterialdb);
    }
}
