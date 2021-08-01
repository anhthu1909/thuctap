package com.springmvcproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvcproject.entity.SurveyTypeEntity;

public interface SurveyTypeRepository extends JpaRepository<SurveyTypeEntity, Long> {
    SurveyTypeEntity findOneByCode(String code);
}
