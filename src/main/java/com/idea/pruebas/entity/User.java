package com.idea.pruebas.entity;

import com.idea.pruebas.enums.RoleUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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

    @ElementCollection
    private List<String> childName = new ArrayList<>();

    @ManyToMany (mappedBy = "users")
    private List <Course> courses;

    @ManyToMany (mappedBy = "users")
    private List <Message> messages;

    private String email;

    private  String password;

    @Enumerated(EnumType.STRING)
    RoleUser role;

}
