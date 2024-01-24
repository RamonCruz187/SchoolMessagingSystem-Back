package com.idea.pruebas.dto;

import com.idea.pruebas.entity.SchoolLevel;
import com.idea.pruebas.entity.Year;
import com.idea.pruebas.enums.NivelEscolar;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolLevelResponseDto implements Serializable {
    public NivelEscolar nivel;

    public List<YearResponseDto> years;

    public List <MessageResponseDto> messages;

    public SchoolLevelResponseDto(SchoolLevel schoolLevel) {

        this(schoolLevel.getNivel(),
                schoolLevel.getYears().stream().map(YearResponseDto::new).toList(), schoolLevel.getMessages().stream().map(MessageResponseDto::new).toList());
    }
}
