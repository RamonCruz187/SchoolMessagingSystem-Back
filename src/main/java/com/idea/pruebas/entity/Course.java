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

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "course_user", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private List<User> users;

}
