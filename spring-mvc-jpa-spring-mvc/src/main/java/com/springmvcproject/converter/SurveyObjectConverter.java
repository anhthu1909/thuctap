package com.springmvcproject.converter;

import com.springmvcproject.dto.SurveyObjectDTO;
import com.springmvcproject.entity.SurveyObjectEntity;
import org.springframework.stereotype.Component;

@Component
public class SurveyObjectConverter {

    public SurveyObjectDTO toDto(SurveyObjectEntity entity) {
        SurveyObjectDTO result = new SurveyObjectDTO();
        result.setId(entity.getId());
        result.setCode(entity.getCode());
        result.setName(entity.getName());
        return result;
    }

    public SurveyObjectEntity toEntity(SurveyObjectDTO dto) {
        SurveyObjectEntity result = new SurveyObjectEntity();
        result.setCode(dto.getCode());
        result.setName(dto.getName());
        return result;
    }

    public SurveyObjectEntity toEntity(SurveyObjectEntity result, SurveyObjectDTO dto) {
        result.setCode(dto.getCode());
        result.setName(dto.getName());
        return result;
    }
}
