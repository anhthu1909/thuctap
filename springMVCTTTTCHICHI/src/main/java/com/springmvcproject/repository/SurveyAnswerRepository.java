package com.laptrinhjavaweb.repository;
import com.laptrinhjavaweb.entity.SurveyAnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SurveyAnswerRepository extends JpaRepository<SurveyAnswerEntity, Long> {
}
