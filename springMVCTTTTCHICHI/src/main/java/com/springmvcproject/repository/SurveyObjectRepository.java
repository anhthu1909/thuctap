package com.springmvcproject.repository;

import com.springmvcproject.entity.SurveyObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface SurveyObjectRepository extends JpaRepository<SurveyObjectEntity, Long> {

}
