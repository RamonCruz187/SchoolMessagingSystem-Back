package com.idea.pruebas.Service.ServiceImpl;

import com.idea.pruebas.Service.CourseService;
import com.idea.pruebas.dto.CourseRequestCreateDto;
import com.idea.pruebas.entity.Course;
import com.idea.pruebas.repository.CourseRepository;
import com.idea.pruebas.repository.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    YearRepository yearRepository;
    @Override
    public void newCourse(CourseRequestCreateDto courseRequestCreateDto) {
        Course course= Course
                .builder()
                .division(courseRequestCreateDto.division)
                .year(yearRepository.getReferenceById(courseRequestCreateDto.year_id))
                .idSchoolLevelCourse(courseRequestCreateDto.idSchoolLevelCourse)
                .idSchool(courseRequestCreateDto.idSchool)
                .build();
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
