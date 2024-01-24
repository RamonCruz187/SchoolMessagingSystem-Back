package com.idea.pruebas.repository;

import com.idea.pruebas.entity.SchoolLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolLevelRepository extends JpaRepository<SchoolLevel, Long> {
}
