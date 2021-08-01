package com.springmvcproject.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springmvcproject.repository.SurveyObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvcproject.converter.SurveyObjectConverter;
import com.springmvcproject.dto.SurveyObjectDTO;
import com.springmvcproject.entity.SurveyObjectEntity;
import com.springmvcproject.service.ISurveyObjectService;

@Service
public class SurveyObjectService implements ISurveyObjectService {

    @Autowired
    private SurveyObjectRepository surveyObjectRepository;

    @Autowired
    private SurveyObjectConverter surveyObjectConverter;

    @Override
    public Map<String, String> findAll() {
        Map<String, String> result = new HashMap<>();
        List<SurveyObjectEntity> entities = surveyObjectRepository.findAll();
        for (SurveyObjectEntity item: entities) {
            result.put(item.getCode(), item.getName());
        }
        return result;
    }

    @Override
    public List<SurveyObjectDTO> findAll(Pageable pageable) {
        List<SurveyObjectDTO> models = new ArrayList<>();
        List<SurveyObjectEntity> entities = surveyObjectRepository.findAll(pageable).getContent();
        for (SurveyObjectEntity item: entities) {
            SurveyObjectDTO surveyObjectDTO = surveyObjectConverter.toDto(item);
            models.add(surveyObjectDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) surveyObjectRepository.count();
    }

    @Override
    public SurveyObjectDTO findById(long id) {
        SurveyObjectEntity entity = surveyObjectRepository.findOne(id);
        return surveyObjectConverter.toDto(entity);
    }

    @Override
    @Transactional
    public SurveyObjectDTO save(SurveyObjectDTO dto) {
        SurveyObjectEntity surveyObjectEntity = new SurveyObjectEntity();
        if (dto.getId() != null) {
            SurveyObjectEntity oldSurveyObject = surveyObjectRepository.findOne(dto.getId());
            surveyObjectEntity = surveyObjectConverter.toEntity(oldSurveyObject, dto);
        } else {
            surveyObjectEntity = surveyObjectConverter.toEntity(dto);
        }
        return surveyObjectConverter.toDto(surveyObjectRepository.save(surveyObjectEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            surveyObjectRepository.delete(id);
        }
    }
}
