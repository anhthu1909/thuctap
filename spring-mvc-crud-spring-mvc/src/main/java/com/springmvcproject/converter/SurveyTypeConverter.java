package com.springmvcproject.converter;

import com.springmvcproject.dto.SurveyTypeDTO;
import org.springframework.stereotype.Component;

import com.springmvcproject.entity.SurveyTypeEntity;

@Component
public class SurveyTypeConverter {

    public SurveyTypeDTO toDto(SurveyTypeEntity entity) {
        SurveyTypeDTO result = new SurveyTypeDTO();
        result.setId(entity.getId());
        result.setCode(entity.getCode());
        result.setName(entity.getName());
        return result;
    }

    public SurveyTypeEntity toEntity(SurveyTypeDTO dto) {
        SurveyTypeEntity result = new SurveyTypeEntity();
        result.setCode(dto.getCode());
        result.setName(dto.getName());
        return result;
    }

    public SurveyTypeEntity toEntity(SurveyTypeEntity result, SurveyTypeDTO dto) {
        result.setCode(dto.getCode());
        result.setName(dto.getName());
        return result;
    }
}
