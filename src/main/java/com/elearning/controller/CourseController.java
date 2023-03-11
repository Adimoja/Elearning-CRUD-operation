package com.elearning.controller;

import com.elearning.entity.Course;
import com.elearning.entity.Student;
import com.elearning.entity.Teacher;
import com.elearning.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("courses")
    public List<Course> gelAllCourses(){
        return courseService.getAllCourses();

    }

    @PostMapping("courses")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @DeleteMapping("courses/{id}")
    public void deleteCourse(@PathVariable("id")Long id){
        courseService.deleteCourse(id);
    }

}
