package com.idea.pruebas.Service;

import com.idea.pruebas.dto.SchoolResponseDto;
import com.idea.pruebas.entity.School;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SchoolService {
    void newSchool( School school);
    List<SchoolResponseDto> schoolList();

    School selectSchool (Long id);

    void deleteSchool(Long id);



}
