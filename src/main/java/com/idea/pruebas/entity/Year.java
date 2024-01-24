package com.idea.pruebas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Year {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String year;

    @ManyToOne( targetEntity = SchoolLevel.class)
    private SchoolLevel schoolLevel;

    private Long idSchoolLevel;

    @OneToMany(targetEntity = Course.class, mappedBy = "year", fetch = FetchType.LAZY)
    private List<Course> course;

    @ManyToMany(mappedBy = "years")
    private List<Message> messages;
}
