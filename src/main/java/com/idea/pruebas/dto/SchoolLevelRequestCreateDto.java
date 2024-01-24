package com.idea.pruebas.dto;

import com.idea.pruebas.enums.NivelEscolar;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SchoolLevelRequestCreateDto implements Serializable {

    public NivelEscolar nivel;

    public Long school_id;

    public SchoolLevelRequestCreateDto(NivelEscolar nivel, Long school_id) {
        this.nivel = nivel;
        this.school_id = school_id;
    }
}
