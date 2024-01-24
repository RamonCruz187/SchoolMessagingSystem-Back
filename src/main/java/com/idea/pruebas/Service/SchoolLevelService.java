package com.idea.pruebas.Service;

import com.idea.pruebas.dto.SchoolLevelRequestCreateDto;

public interface SchoolLevelService {

    void newLevel(SchoolLevelRequestCreateDto schoolLevelRequestCreateDto);

    void deleteLevel (Long id);
}
