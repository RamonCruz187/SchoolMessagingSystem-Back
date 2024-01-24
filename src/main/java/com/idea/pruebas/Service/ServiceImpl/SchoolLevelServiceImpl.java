package com.idea.pruebas.Service.ServiceImpl;

import com.idea.pruebas.Service.SchoolLevelService;
import com.idea.pruebas.dto.SchoolLevelRequestCreateDto;
import com.idea.pruebas.entity.SchoolLevel;
import com.idea.pruebas.repository.SchoolLevelRepository;
import com.idea.pruebas.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolLevelServiceImpl implements SchoolLevelService {

    @Autowired
    SchoolLevelRepository schoolLevelRepository;
    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public void newLevel(SchoolLevelRequestCreateDto schoolLevelRequestCreateDto) {
        SchoolLevel schoolLevel= SchoolLevel
                .builder()
                .nivel(schoolLevelRequestCreateDto.nivel)
                .school(schoolRepository.getReferenceById(schoolLevelRequestCreateDto.school_id))
                .build();
        schoolLevelRepository.save(schoolLevel);
    }

    @Override
    public void deleteLevel(Long id) {
        schoolLevelRepository.deleteById(id);
    }
}
