package com.elearning.controller;

import com.elearning.service.EnrollmentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {

    private EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("enrollment/course/{courseId}/student/{studentId}")
    public void setCoursesAndStudents(@PathVariable("courseId") Long courseId,
                                      @PathVariable("studentId") Long studentId){
        enrollmentService.setCoursesAndStudents(courseId,studentId);
    }
}
