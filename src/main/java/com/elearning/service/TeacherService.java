package com.elearning.service;

import com.elearning.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher addTeacher(Teacher teacher);

    List<Teacher> getAllTeachers();

    Teacher setTeacherToCourse(Long teacherID, Long courseID);
}
