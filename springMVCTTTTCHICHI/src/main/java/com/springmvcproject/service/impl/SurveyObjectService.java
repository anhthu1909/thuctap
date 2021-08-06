package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.SurveyObjectConverter;
import com.laptrinhjavaweb.dto.SurveyObjectDTO;
import com.laptrinhjavaweb.entity.SurveyObjectEntity;
import com.laptrinhjavaweb.repository.SurveyObjectRepository;
import com.laptrinhjavaweb.service.ISurveyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyObjectService implements ISurveyObject {
    @Autowired
    private SurveyObjectRepository surveyObjectRepository;
    @Autowired
    private SurveyObjectConverter surveyObjectConverter;
    @Override
    public List<SurveyObjectDTO> findAll(){
        List<SurveyObjectDTO> models= new ArrayList<>();
        List<SurveyObjectEntity> entities=surveyObjectRepository.findAll();
        for(SurveyObjectEntity item: entities){
            SurveyObjectDTO surveyObjectDTO= surveyObjectConverter.toDto(item);
            models.add(surveyObjectDTO);

        }
        return models;


    }
    @Override
    public SurveyObjectDTO findById(long id){
        SurveyObjectEntity entity= surveyObjectRepository.findOne(id);
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
