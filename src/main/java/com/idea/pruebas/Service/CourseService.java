package com.idea.pruebas.Service;

import com.idea.pruebas.dto.CourseRequestCreateDto;

public interface CourseService {

    void newCourse(CourseRequestCreateDto courseRequestCreateDto);

    void deleteCourse(Long id);
}
