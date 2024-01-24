package com.idea.pruebas.Service.ServiceImpl;

import com.idea.pruebas.Service.MessageService;
import com.idea.pruebas.entity.*;
import com.idea.pruebas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    YearRepository yearRepository;

    @Autowired
    SchoolLevelRepository schoolLevelRepository;

    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public void newMessageCourse(Long courseId, Message message) {
        Course course = courseRepository.getReferenceById(courseId);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        message.setCourses(courses);
        messageRepository.save(message);
    }

    @Override
    public void newMessageYear(Long yearId, Message message) {
        Year year = yearRepository.getReferenceById(yearId);
        List <Year> years = new ArrayList<>();
        years.add(year);
        message.setYears(years);
        messageRepository.save(message);
        List <Course> courses= courseRepository.findCoursesByYear_Id(yearId);
        message.setCourses(courses);
        messageRepository.save(message);
    }

    @Override
    public void newMessageSchoolLevel(Long schoolLevelId, Message message) {
        SchoolLevel schoolLevel = schoolLevelRepository.getReferenceById(schoolLevelId);
        List <SchoolLevel> schoolLevels = new ArrayList<>();
        schoolLevels.add(schoolLevel);
        message.setSchoolLevels(schoolLevels);
        messageRepository.save(message);
        List <Year> years= yearRepository.findYearsByIdSchoolLevel(schoolLevelId);
        message.setYears(years);
        messageRepository.save(message);
        List <Course> courses= courseRepository.findCoursesByIdSchoolLevelCourse(schoolLevelId);
        message.setCourses(courses);
        messageRepository.save(message);
    }

    @Override
    public void newSchoolMessage(Long schoolId, Message message) {
        School school = schoolRepository.getReferenceById(schoolId);
        List <School> schools = new ArrayList<>();
        schools.add(school);
        message.setSchools(schools);
        messageRepository.save(message);
        List <Course> courses= courseRepository.findCoursesByIdSchool(schoolId);
        message.setCourses(courses);
        messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Long id) {

    }
}
