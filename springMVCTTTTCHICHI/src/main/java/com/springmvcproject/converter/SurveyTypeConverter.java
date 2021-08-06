package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.SurveyTypeDTO;
import com.laptrinhjavaweb.entity.SurveyTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class SurveyTypeConverter {
    public SurveyTypeDTO toDto (SurveyTypeEntity entity){
        SurveyTypeDTO result=new SurveyTypeDTO();
        result.setId(entity.getId());
        result.setName(entity.getName());
        return result;
    }
    public SurveyTypeEntity toEntity (SurveyTypeDTO dto){

        SurveyTypeEntity result=new SurveyTypeEntity();
        result.setName(dto.getName());
        return result;
    }
    public SurveyTypeEntity toEntity(SurveyTypeEntity result, SurveyTypeDTO dto) {
        result.setName(dto.getName());
        return result;
    }
}
