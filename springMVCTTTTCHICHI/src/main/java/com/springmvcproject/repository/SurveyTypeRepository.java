package com.springmvcproject.repository;

import com.springmvcproject.entity.SurveyTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyTypeRepository extends  JpaRepository<SurveyTypeEntity,Long>{

}
