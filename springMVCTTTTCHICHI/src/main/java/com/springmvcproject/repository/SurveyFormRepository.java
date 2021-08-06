package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.SurveyFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyFormRepository extends JpaRepository<SurveyFormEntity, Long> {
    SurveyFormEntity findOneByContent(String content);
}