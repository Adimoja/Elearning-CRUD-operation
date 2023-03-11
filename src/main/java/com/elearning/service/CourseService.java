package com.elearning.service;

import com.elearning.entity.Course;
import com.elearning.entity.Student;
import com.elearning.entity.Teacher;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course addCourse(Course course);


    void deleteCourse(Long id);

}
