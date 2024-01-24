package com.idea.pruebas.entity;

import com.idea.pruebas.enums.NivelEscolar;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SchoolLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    NivelEscolar nivel;

    @ManyToOne(targetEntity = School.class)//para que traiga todos los datos inmediatamente en la primera llamada, después está LAZY
    private School school;

    @OneToMany (targetEntity = Year.class, mappedBy = "schoolLevel", fetch = FetchType.LAZY)
    private List <Year> years;

    @ManyToMany(mappedBy = "schoolLevels")
    private List<Message> messages;

}
