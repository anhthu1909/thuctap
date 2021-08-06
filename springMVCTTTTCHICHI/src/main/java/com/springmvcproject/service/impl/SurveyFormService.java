package com.springmvcproject.service.impl;

import com.springmvcproject.converter.SurveyFormConverter;
import com.springmvcproject.dto.SurveyFormDTO;
import com.springmvcproject.entity.SurveyFormEntity;
import com.springmvcproject.repository.SurveyFormRepository;
import com.springmvcproject.service.ISurveyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class SurveyFormService implements ISurveyForm {

    @Autowired
    private SurveyFormRepository surveyFormRepository;

    @Autowired
    private SurveyFormConverter surveyFormConverter;

    @Override
    public List<SurveyFormDTO> findAll() {
        List<SurveyFormDTO> models = new ArrayList<>();
        List<SurveyFormEntity> entities =surveyFormRepository.findAll();
        for (SurveyFormEntity item:entities) {
            SurveyFormDTO surveyFormDTO= surveyFormConverter.toDto(item);
            models.add(surveyFormDTO);
        }
        return models;
    }

    @Override
    public SurveyFormDTO findById(long id){
        SurveyFormEntity entity=surveyFormRepository.findOne(id);
        return surveyFormConverter.toDto(entity);
    }

    @Override
    @Transactional
    public SurveyFormDTO save(SurveyFormDTO dto) {

        SurveyFormEntity surveyFormEntity = new SurveyFormEntity();
        if (dto.getId() != null) {
            SurveyFormEntity oldSurveyForm = surveyFormRepository.findOne(dto.getId());
            surveyFormEntity = surveyFormConverter.toEntity(oldSurveyForm, dto);
        } else {
            surveyFormEntity = surveyFormConverter.toEntity(dto);
        }
        return surveyFormConverter.toDto(surveyFormRepository.save(surveyFormEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            surveyFormRepository.delete(id);
        }
    }

}
