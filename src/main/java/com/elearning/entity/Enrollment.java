package com.elearning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_course_map")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {

    @Id
    @SequenceGenerator(
            name = "enrollment_sequence",
            sequenceName = "enrollment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "enrollment_sequence"

    )
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "course_id",
    referencedColumnName = "courseId")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "student_id",
    referencedColumnName = "studentId")
    private Student student;
}
