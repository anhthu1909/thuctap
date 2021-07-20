package com.springmvcproject.repository;

import com.springmvcproject.entity.SurveyFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyFormRepository extends JpaRepository<SurveyFormEntity, Long> {
}
