package com.idea.pruebas.dto;

import com.idea.pruebas.entity.Course;
import com.idea.pruebas.entity.Student;

import java.util.List;

public class UserRequestCourseDto {

    public String  student;

    public Long course;

    public UserRequestCourseDto(String student, Long course) {
        this.student = student;
        this.course = course;
    }
}
