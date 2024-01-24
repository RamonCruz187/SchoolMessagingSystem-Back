package com.idea.pruebas.Service.ServiceImpl;

import com.idea.pruebas.Service.YearService;
import com.idea.pruebas.dto.YearRequestCreateDto;
import com.idea.pruebas.entity.Year;
import com.idea.pruebas.repository.SchoolLevelRepository;
import com.idea.pruebas.repository.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YearServiceImpl implements YearService {

    @Autowired
    YearRepository yearRepository;

    @Autowired
    SchoolLevelRepository schoolLevelRepository;

    @Override
    public void newYear(YearRequestCreateDto yearRequestCreateDto) {
        Year year= Year
                .builder()
                .year(yearRequestCreateDto.year)
                .schoolLevel(schoolLevelRepository.getReferenceById(yearRequestCreateDto.schoolLevel_id))
                .idSchoolLevel(schoolLevelRepository.getReferenceById(yearRequestCreateDto.schoolLevel_id).getId())
                .build();
        yearRepository.save(year);
    }

    @Override
    public void deleteYear(Long id) {
        yearRepository.deleteById(id);
    }
}
