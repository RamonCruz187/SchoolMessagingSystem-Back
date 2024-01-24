package com.idea.pruebas.entity;

import com.idea.pruebas.enums.NivelEscolar;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = SchoolLevel.class, fetch = FetchType.LAZY, mappedBy = "school")
    private List <SchoolLevel> levels;

    @ManyToMany(mappedBy = "schools")
    private List<Message> messages;
}
