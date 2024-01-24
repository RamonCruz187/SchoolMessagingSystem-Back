package com.idea.pruebas.dto;

import com.idea.pruebas.entity.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CourseRequestCreateDto implements Serializable {

    public String division;

    public Long year_id;

    public Long idSchoolLevelCourse;

    public Long idSchool;

    public CourseRequestCreateDto(Course division, Long year_id, Long idSchoolLevelCourse, Long idSchool) {
        this.division = division.getDivision();
        this.year_id = year_id;
        this.idSchoolLevelCourse=idSchoolLevelCourse;
        this.idSchool= idSchool;
    }
}
