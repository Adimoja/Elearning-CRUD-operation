package com.elearning.service;

import com.elearning.entity.CourseMaterial;

import java.util.List;

public interface CourseMaterialService {
    CourseMaterial addCourseMaterial(CourseMaterial courseMaterial);

    List<CourseMaterial> getAllcourseMaterial();

    CourseMaterial addExistingCourse(Long id,Long idCourse);
}
