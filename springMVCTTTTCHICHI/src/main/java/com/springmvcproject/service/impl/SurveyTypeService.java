package com.springmvcproject.service.impl;

import com.springmvcproject.converter.SurveyTypeConverter;
import com.springmvcproject.dto.SurveyTypeDTO;
import com.springmvcproject.entity.SurveyTypeEntity;
import com.springmvcproject.repository.SurveyTypeRepository;
import com.springmvcproject.service.ISurveyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyTypeService implements ISurveyType {

    @Autowired
    private SurveyTypeConverter surveyTypeConverter;
    @Autowired
    private SurveyTypeRepository surveyTypeRepository;
    @Override
    public List<SurveyTypeDTO> findAll() {
        List<SurveyTypeDTO> models = new ArrayList<>();
        List<SurveyTypeEntity> entities = surveyTypeRepository.findAll();
        for (SurveyTypeEntity item:entities) {
            SurveyTypeDTO surveyTypeDTO = surveyTypeConverter.toDto(item);
            models.add(surveyTypeDTO);
        }
        return models;
    }
   @Override
    public SurveyTypeDTO findById(long id){
        SurveyTypeEntity entity= surveyTypeRepository.findOne(id);
        return surveyTypeConverter.toDto(entity);
    }

    @Override
    @Transactional
    public SurveyTypeDTO save(SurveyTypeDTO dto) {

        SurveyTypeEntity surveyTypeEntity = new SurveyTypeEntity();
        if (dto.getId() != null) {
            SurveyTypeEntity oldSurveyType = surveyTypeRepository.findOne(dto.getId());
            surveyTypeEntity = surveyTypeConverter.toEntity(oldSurveyType, dto);
        } else {
            surveyTypeEntity = surveyTypeConverter.toEntity(dto);
        }
        return surveyTypeConverter.toDto(surveyTypeRepository.save(surveyTypeEntity));
    }


    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            surveyTypeRepository.delete(id);
        }
    }

}
