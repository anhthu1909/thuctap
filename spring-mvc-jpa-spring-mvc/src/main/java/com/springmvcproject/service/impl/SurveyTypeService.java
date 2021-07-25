package com.springmvcproject.service.impl;

import com.springmvcproject.converter.SurveyTypeConverter;
import com.springmvcproject.dto.SurveyTypeDTO;
import com.springmvcproject.entity.SurveyTypeEntity;
import com.springmvcproject.repository.SurveyTypeRepository;
import com.springmvcproject.service.ISurveyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SurveyTypeService implements ISurveyTypeService {

    @Autowired
    private SurveyTypeRepository surveyTypeRepository;

    @Autowired
    private SurveyTypeConverter surveyTypeConverter;

    @Override
    public Map<String, String> findAll() {
        Map<String, String> result = new HashMap<>();
        List<SurveyTypeEntity> entities = surveyTypeRepository.findAll();
        for (SurveyTypeEntity item: entities) {
            result.put(item.getCode(), item.getName());
        }
        return result;
    }

    @Override
    public List<SurveyTypeDTO> findAll(Pageable pageable) {
        List<SurveyTypeDTO> models = new ArrayList<>();
        List<SurveyTypeEntity> entities = surveyTypeRepository.findAll(pageable).getContent();
        for (SurveyTypeEntity item: entities) {
            SurveyTypeDTO surveyTypeDTO = surveyTypeConverter.toDto(item);
            models.add(surveyTypeDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) surveyTypeRepository.count();
    }

    @Override
    public SurveyTypeDTO findById(long id) {
        SurveyTypeEntity entity = surveyTypeRepository.findOne(id);
        return surveyTypeConverter.toDto(entity);
    }

    @Override
    @Transactional
    public SurveyTypeDTO save(SurveyTypeDTO dto) {
        SurveyTypeEntity surveyTypeEntity = new SurveyTypeEntity();
        if (dto.getId() != null) {
            SurveyTypeEntity oldNew = surveyTypeRepository.findOne(dto.getId());
            surveyTypeEntity = surveyTypeConverter.toEntity(oldNew, dto);
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
