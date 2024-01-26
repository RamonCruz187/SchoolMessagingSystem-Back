package com.idea.pruebas.dto;

import com.idea.pruebas.entity.Course;
import com.idea.pruebas.entity.User;
import com.idea.pruebas.enums.RoleUser;
import com.idea.pruebas.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestCreateDto implements Serializable {

    public String username;
    public String email;
    public String password;
    public RoleUser role;

    public UserRequestCreateDto(String username, String email, String password, RoleUser role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
