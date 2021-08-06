package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.SurveyObjectDTO;

import com.laptrinhjavaweb.entity.SurveyObjectEntity;
import org.springframework.stereotype.Component;

@Component
public class SurveyObjectConverter {
    public SurveyObjectDTO toDto (SurveyObjectEntity entity){
        SurveyObjectDTO result=new SurveyObjectDTO();
        result.setId(entity.getId());
        result.setName(entity.getName());
        return result;
    }

    public SurveyObjectEntity toEntity(SurveyObjectDTO dto){
        SurveyObjectEntity result = new SurveyObjectEntity();
        result.setName(dto.getName());
        return result;
    }
    public SurveyObjectEntity toEntity(SurveyObjectEntity result, SurveyObjectDTO dto) {
        result.setName(dto.getName());
        return result;
    }
}
