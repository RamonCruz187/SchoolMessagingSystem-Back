package com.idea.pruebas.Service;

import com.idea.pruebas.dto.YearRequestCreateDto;

public interface YearService {
    void newYear(YearRequestCreateDto yearRequestCreateDto);

    void deleteYear(Long id);
}
