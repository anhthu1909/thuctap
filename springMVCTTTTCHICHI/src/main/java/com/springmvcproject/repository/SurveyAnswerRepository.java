package com.springmvcproject.repository;
import com.springmvcproject.entity.SurveyAnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SurveyAnswerRepository extends JpaRepository<SurveyAnswerEntity, Long> {

}
