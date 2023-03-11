package com.elearning.controller;

import com.elearning.entity.Teacher;
import com.elearning.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("teachers")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
    }
    @GetMapping("teachers")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @PutMapping("teachers/{teacherId}/{courseId}")
    public Teacher setTeacherToCourse(@PathVariable("teacherId") Long teacherID,
                                      @PathVariable("courseId") Long courseID){
        return teacherService.setTeacherToCourse(teacherID,courseID);
    }
}
