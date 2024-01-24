package com.idea.pruebas.dto;

import com.idea.pruebas.entity.Message;
import com.idea.pruebas.entity.School;
import com.idea.pruebas.entity.SchoolLevel;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolResponseDto implements Serializable {

    public String name;
    public List<SchoolLevelResponseDto> schoolLevel;
    public List<MessageResponseDto> messages;

    public SchoolResponseDto(School school) {
        this(school.getName(),
                school.getLevels().stream().map(SchoolLevelResponseDto::new).toList(),
                school.getMessages().stream().map(MessageResponseDto::new).toList()
                );
    }
}
