package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.SurveyFormDTO;
import com.laptrinhjavaweb.entity.SurveyFormEntity;
import org.springframework.stereotype.Component;

@Component
public class SurveyFormConverter {
    public SurveyFormDTO toDto(SurveyFormEntity entity){
        SurveyFormDTO result = new SurveyFormDTO();
        result.setId(entity.getId());
        result.setContent(entity.getContent());
        return result;
    }
    public SurveyFormEntity toEntity(SurveyFormDTO dto){
        SurveyFormEntity result = new SurveyFormEntity();
        result.setContent(dto.getContent());
        return result;
    }
    public SurveyFormEntity toEntity(SurveyFormEntity result, SurveyFormDTO dto) {
        result.setContent(dto.getContent());
        return result;
    }
}
