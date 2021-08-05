package com.springmvcproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvcproject.entity.SurveyFormEntity;

public interface SurveyFormRepository extends JpaRepository<SurveyFormEntity, Long> {
    SurveyFormEntity findOneById(Long id);
}
