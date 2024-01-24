package com.idea.pruebas.dto;

import com.idea.pruebas.entity.Year;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class YearRequestCreateDto implements Serializable {
    public String year;
    public Long schoolLevel_id;
    public Long idSchoolLevel;

    public YearRequestCreateDto(Year year, Long schoolLevel_id, Long idSchoolLevel) {
        this.year= year.getYear();
        this.schoolLevel_id= schoolLevel_id;
        this.idSchoolLevel=idSchoolLevel;
    }
}
