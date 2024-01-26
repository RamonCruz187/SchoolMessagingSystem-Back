package com.idea.pruebas.entity;

import com.idea.pruebas.enums.RoleUser;
import com.idea.pruebas.repository.CourseRepository;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToMany (targetEntity = Student.class, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Student> students;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_course", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private List<Course> courses;

    @ManyToMany (mappedBy = "users")
    private List <Message> messages;

    private String email;

    private  String password;

    @Enumerated(EnumType.STRING)
    private RoleUser role;


}
