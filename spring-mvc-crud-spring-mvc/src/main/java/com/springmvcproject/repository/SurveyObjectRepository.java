package com.springmvcproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvcproject.entity.SurveyObjectEntity;

public interface SurveyObjectRepository extends JpaRepository<SurveyObjectEntity, Long> {
    SurveyObjectEntity findOneByCode(String code);
}
