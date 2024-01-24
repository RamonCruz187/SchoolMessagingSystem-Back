package com.idea.pruebas.dto;

import com.idea.pruebas.entity.Message;
import com.idea.pruebas.entity.SchoolLevel;
import com.idea.pruebas.entity.Year;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YearResponseDto implements Serializable {

    public String year;

    public List<CourseResponseDto> courses;

    public List <MessageResponseDto> messages;


    public YearResponseDto(Year year) {
        this(year.getYear(), year.getCourse().stream().map(CourseResponseDto::new).toList(), year.getMessages().stream().map(MessageResponseDto::new).toList());

    }
}
