package com.idea.pruebas.dto;

import com.idea.pruebas.entity.Course;
import com.idea.pruebas.entity.Message;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponseDto implements Serializable {

    public String division;

    public List <MessageResponseDto> messages;


    public CourseResponseDto(Course division) {
        this(division.getDivision(), division.getMessages().stream().map(MessageResponseDto::new).toList());
    }
}
