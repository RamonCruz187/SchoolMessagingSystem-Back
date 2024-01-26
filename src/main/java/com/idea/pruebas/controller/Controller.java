package com.idea.pruebas.controller;

import com.idea.pruebas.Service.*;
import com.idea.pruebas.dto.*;
import com.idea.pruebas.entity.*;
import com.idea.pruebas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
public class Controller {

    @Autowired
    SchoolRepository schoolRepo;

    @Autowired
    SchoolService schoolService;

    @Autowired
    SchoolLevelRepository schoolLevelRepository;

    @Autowired
    SchoolLevelService schoolLevelService;

    @Autowired
    YearRepository yearRepository;

    @Autowired
    YearService yearService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseService courseService;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    MessageService messageService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/schoolList")
    public List<SchoolResponseDto> schoolList(){List<SchoolResponseDto> lista = schoolService.schoolList();
        return lista;
    }

    @PostMapping("/newSchool")
    public void newSchool(@RequestBody School school){
        schoolService.newSchool(school);}

    @GetMapping("/selectSchool/{schoolId}")
    public School selectSchool(@PathVariable Long schoolId){
        return schoolService.selectSchool(schoolId);
    }

    @DeleteMapping("/deleteSchool/{schoolId}")
    public void deleteSchool(@PathVariable Long schoolId){
        schoolService.deleteSchool(schoolId);
    }

    @PostMapping("/newSchoolLevel")
    public void newLevel(@RequestBody SchoolLevelRequestCreateDto schoolLevelRequestCreateDto){
        schoolLevelService.newLevel(schoolLevelRequestCreateDto);
    }

    @DeleteMapping("/deleteSchoolLevel/{schoolLevelId}")
    public void deleteLevel(@PathVariable Long schoolLevelId){
        schoolLevelService.deleteLevel(schoolLevelId);
    }

    @PostMapping("/newYear")
    public void newYear(@RequestBody YearRequestCreateDto yearRequestCreateDto){
        yearService.newYear(yearRequestCreateDto);
    }

    @DeleteMapping("/deleteYear/{yearId}")
    public void deleteYear(@PathVariable Long yearId){
        yearService.deleteYear(yearId);
    }

    @PostMapping("/newCourse")
    public void newCourse(@RequestBody CourseRequestCreateDto courseRequestCreateDto){
        courseService.newCourse(courseRequestCreateDto);
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public void deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
    }

    @PostMapping("/newMessageCourse/{courseId}")
    public void newMessageCourse (@PathVariable Long courseId, @RequestBody Message message){
        messageService.newMessageCourse(courseId, message);
    }

    @PostMapping("/newMessageYear/{yearId}")
    public void newMessageYear (@PathVariable Long yearId, @RequestBody Message message){
        messageService.newMessageYear(yearId, message);
    }

    @PostMapping("/newMessageSchoolLevel/{schoolLevelId}")
    public void newMessageSchoolLevel (@PathVariable Long schoolLevelId, @RequestBody Message message){
        messageService.newMessageSchoolLevel(schoolLevelId, message);
    }

    @PostMapping("/newMessageSchool/{schoolId}")
    public void newSchoolMessage(@PathVariable Long schoolId, @RequestBody Message message){
        messageService.newSchoolMessage(schoolId,message);
    }

    @DeleteMapping("/deleteMessage/{messageId}")
    void deleteMessage(@PathVariable Long messageId){
        messageService.deleteMessage(messageId);
    }

    @PostMapping("/newUser")
    public void newUser(@RequestBody UserRequestCreateDto userRequestCreateDto){
        User user = User.builder()
                .username(userRequestCreateDto.username)
                .email(userRequestCreateDto.email)
                .password(userRequestCreateDto.password)
                .role(userRequestCreateDto.role)
                .build();
        userRepository.save(user);
    }

    @PostMapping("/newUserCourse/{userId}")
    public void newUserCourse(@PathVariable Long userId, @RequestBody UserRequestCourseDto userRequestCourseDto){
       Student student= new Student();
       student.setUser(userRepository.getReferenceById(userId));
       student.setName(userRequestCourseDto.student);
       studentRepository.save(student);
       User user = userRepository.getReferenceById(userId);
       user.getCourses().add(courseRepository.getReferenceById(userRequestCourseDto.course));
       userRepository.save(user);


    }

    @GetMapping("/MessageList/{userId}")
    public List <MessageResponseDto> messageList(@ PathVariable Long userId){
        User user = userRepository.getReferenceById(userId);
        List <Course> courses = user.getCourses();
        List <MessageResponseDto> messages = new ArrayList<>();
        for(Course course : courses){
            messages.addAll(course.getMessages().stream().map(MessageResponseDto::new).toList());

        }
        return messages;
    }

}

