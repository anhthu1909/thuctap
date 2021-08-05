package com.springmvcproject.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springmvcproject.entity.SurveyObjectEntity;
import com.springmvcproject.entity.SurveyTypeEntity;
import com.springmvcproject.repository.SurveyFormRepository;
import com.springmvcproject.repository.SurveyObjectRepository;
import com.springmvcproject.repository.SurveyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvcproject.converter.SurveyFormConverter;
import com.springmvcproject.dto.SurveyFormDTO;
import com.springmvcproject.entity.SurveyFormEntity;
import com.springmvcproject.service.ISurveyFormService;

@Service
public class SurveyFormService implements ISurveyFormService {

    @Autowired
    private SurveyFormRepository surveyFormRepository;

    @Autowired
    private SurveyObjectRepository surveyObjectRepository;

    @Autowired
    private SurveyTypeRepository surveyTypeRepository;

    @Autowired
    private SurveyFormConverter surveyFormConverter;

    @Override
    public Map<String, String> findAll() {
        Map<String, String> result = new HashMap<>();
        List<SurveyFormEntity> entities = surveyFormRepository.findAll();
        for (SurveyFormEntity item: entities) {
            result.put(item.getSurveyObject().getCode(), item.getSurveyObject().getName());
        }
        return result;
    }

    @Override
    public List<SurveyFormDTO> findAll(Pageable pageable) {
        List<SurveyFormDTO> models = new ArrayList<>();
        List<SurveyFormEntity> entities = surveyFormRepository.findAll(pageable).getContent();
        for (SurveyFormEntity item: entities) {
            SurveyFormDTO surveyFormDTO = surveyFormConverter.toDto(item);
            models.add(surveyFormDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) surveyFormRepository.count();
    }

    @Override
    public SurveyFormDTO findById(long id) {
        SurveyFormEntity entity = surveyFormRepository.findOne(id);
        return surveyFormConverter.toDto(entity);
    }

    @Override
    @Transactional
    public SurveyFormDTO save(SurveyFormDTO dto) {
        SurveyObjectEntity surveyObject = surveyObjectRepository.findOneByCode(dto.getSurveyObjectCode());
        SurveyTypeEntity surveyType = surveyTypeRepository.findOneByCode(dto.getSurveyTypeCode());
        SurveyFormEntity surveyFormEntity = new SurveyFormEntity();
        if (dto.getId() != null) {
            SurveyFormEntity oldSurveyForm = surveyFormRepository.findOne(dto.getId());
            oldSurveyForm.setSurveyObject(surveyObject);
            oldSurveyForm.setSurveyType(surveyType);
            surveyFormEntity = surveyFormConverter.toEntity(oldSurveyForm, dto);
        } else {
            surveyFormEntity = surveyFormConverter.toEntity(dto);
            surveyFormEntity.setSurveyObject(surveyObject);
            surveyFormEntity.setSurveyType(surveyType);
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
