package com.idea.pruebas.entity;

import com.idea.pruebas.enums.NivelEscolar;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String division;

    private Long idSchoolLevelCourse;

    private Long idSchool;

    @ManyToOne (targetEntity = Year.class)
    private Year year;

    @ManyToMany(mappedBy = "courses")
    private List<Message> messages;


    @ManyToMany (mappedBy = "courses")
    private List <User> users;

}
