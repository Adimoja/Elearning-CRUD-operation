package com.elearning.controller;

import com.elearning.entity.CourseMaterial;
import com.elearning.service.CourseMaterialService;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseMaterialController {
    private CourseMaterialService courseMaterialService;

    public CourseMaterialController(CourseMaterialService courseMaterialService) {
        this.courseMaterialService = courseMaterialService;
    }

    @PostMapping("course-material")
    public CourseMaterial addCourseMaterial(@RequestBody CourseMaterial courseMaterial){
        return courseMaterialService.addCourseMaterial(courseMaterial);
    }

    @GetMapping("course-material")
    public List<CourseMaterial> getAllcourseMaterial(){
        return courseMaterialService.getAllcourseMaterial();
    }

    @PutMapping("course-material/{id-material}/{id-course}")
    public CourseMaterial addExistingCourse(@PathVariable("id-material") Long id,@PathVariable("id-course") Long idCourse){
        return courseMaterialService.addExistingCourse(id,idCourse);
    }
}
