package com.idea.pruebas.repository;

import com.idea.pruebas.entity.Course;
import com.idea.pruebas.entity.Year;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YearRepository extends JpaRepository<Year, Long> {
    List<Year> findYearsByIdSchoolLevel(@Param("idSchoolLevel") Long id);

}
