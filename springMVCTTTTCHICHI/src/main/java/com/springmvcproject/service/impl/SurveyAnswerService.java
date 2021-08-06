package com.laptrinhjavaweb.service.impl;


import com.laptrinhjavaweb.converter.SurveyAnswerConverter;
import com.laptrinhjavaweb.dto.SurveyAnswerDTO;
import com.laptrinhjavaweb.entity.SurveyAnswerEntity;
import com.laptrinhjavaweb.entity.SurveyFormEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.SurveyAnswerRepository;
import com.laptrinhjavaweb.repository.SurveyFormRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.ISurveyAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public  class SurveyAnswerService implements ISurveyAnswer {
    @Autowired
    private SurveyAnswerRepository surveyAnswerRepository;
    @Autowired
    private SurveyFormRepository surveyFormRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SurveyAnswerConverter surveyAnswerConverter;

    @Override
    public List<SurveyAnswerDTO> findAll() {
        List<SurveyAnswerDTO> models = new ArrayList<>();
        List<SurveyAnswerEntity> entities =surveyAnswerRepository.findAll();
        for (SurveyAnswerEntity item:entities) {
            SurveyAnswerDTO surveyAnswerDTO = surveyAnswerConverter.toDto(item);
            models.add(surveyAnswerDTO);
        }
        return models;
    }
    @Override
    public SurveyAnswerDTO findById(long id){
        SurveyAnswerEntity entity=surveyAnswerRepository.findOne(id);
        return surveyAnswerConverter.toDto(entity);
    }

    @Override
    @Transactional
    public SurveyAnswerDTO save(SurveyAnswerDTO dto) {
        SurveyFormEntity surveyFormEntity =surveyFormRepository.findOneByContent(dto.getSurveyFormContent());
        UserEntity userEntity = userRepository.findOneByFullname(dto.getUsresFullname());
        SurveyAnswerEntity surveyAnswerEntity = new SurveyAnswerEntity();
        if (dto.getId() != null) {
            SurveyAnswerEntity oldSurveyAnswer = surveyAnswerRepository.findOne(dto.getId());
            oldSurveyAnswer.setSurveyform(surveyFormEntity);
            oldSurveyAnswer.setUsers(userEntity);
            surveyAnswerEntity = surveyAnswerConverter.toEntity(oldSurveyAnswer, dto);
        } else {
            surveyAnswerEntity = surveyAnswerConverter.toEntity(dto);
            surveyAnswerEntity.setSurveyform(surveyFormEntity);
            surveyAnswerEntity.setUsers(userEntity);

        }
        return surveyAnswerConverter.toDto(surveyAnswerRepository.save(surveyAnswerEntity));
    }


    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            surveyAnswerRepository.delete(id);
        }
    }

}
