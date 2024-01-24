package com.idea.pruebas.repository;

import com.idea.pruebas.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCoursesByYear_Id(@Param("year_id") Long id);
    List<Course> findCoursesByIdSchoolLevelCourse(@Param("id_school_level_course") Long id);
    List<Course> findCoursesByIdSchool(@Param("id_school") Long id);


}
