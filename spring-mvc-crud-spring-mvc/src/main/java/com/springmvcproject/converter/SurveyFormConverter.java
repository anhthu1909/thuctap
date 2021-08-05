package com.springmvcproject.converter;

import com.springmvcproject.dto.SurveyFormDTO;
import org.springframework.stereotype.Component;

import com.springmvcproject.entity.SurveyFormEntity;

@Component
public class SurveyFormConverter {

    public SurveyFormDTO toDto(SurveyFormEntity entity) {
        SurveyFormDTO result = new SurveyFormDTO();
        result.setId(entity.getId());
//        result.setName(entity.getName());
        result.setContent(entity.getContent());
        result.setSurveyObjectCode(entity.getSurveyObject().getCode());
        result.setSurveyObjectName(entity.getSurveyObject().getName());
        result.setSurveyTypeCode(entity.getSurveyType().getCode());
        result.setSurveyTypeName(entity.getSurveyType().getName());
        return result;
    }

    public SurveyFormEntity toEntity(SurveyFormDTO dto) {
        SurveyFormEntity result = new SurveyFormEntity();
        return result;
    }

    public SurveyFormEntity toEntity(SurveyFormEntity result, SurveyFormDTO dto) {
        return result;
    }
}
