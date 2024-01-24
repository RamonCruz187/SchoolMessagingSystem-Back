package com.idea.pruebas.Service.ServiceImpl;


import com.idea.pruebas.Service.SchoolService;
import com.idea.pruebas.dto.SchoolResponseDto;
import com.idea.pruebas.entity.School;
import com.idea.pruebas.repository.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public void newSchool(School school) {
        schoolRepository.save(school);
    }

    @Override
    public List<SchoolResponseDto> schoolList() {
        List<SchoolResponseDto> lista = schoolRepository.findAll().stream().map(SchoolResponseDto::new).toList();
        return lista ;
    }

    @Override
    public School selectSchool(Long id) {
        School school = schoolRepository.findById(id).orElse(null);
        return school;
    }

    @Override
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }
}
