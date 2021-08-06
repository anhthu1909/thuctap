package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.SurveyAnswerDTO;
import com.laptrinhjavaweb.entity.SurveyAnswerEntity;
import org.springframework.stereotype.Component;

@Component
public class SurveyAnswerConverter {
    public SurveyAnswerDTO toDto(SurveyAnswerEntity entity)
    {
      SurveyAnswerDTO result=new SurveyAnswerDTO();
      result.setId(entity.getId());
      result.setContent(entity.getContent());
      result.setSurveyFormContent(entity.getSurveyform().getContent());
      return result;
    }
    public SurveyAnswerEntity toEntity(SurveyAnswerDTO dto)
    {
        SurveyAnswerEntity result=new SurveyAnswerEntity();
        result.setContent(dto.getContent());
        return result;
    }
    public SurveyAnswerEntity toEntity(SurveyAnswerEntity result, SurveyAnswerDTO dto)
    {
        result.setContent(dto.getContent());
        return result;
    }




}
