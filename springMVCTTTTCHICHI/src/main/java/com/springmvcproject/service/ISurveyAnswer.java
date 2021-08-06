package com.springmvcproject.service;

import com.springmvcproject.dto.SurveyAnswerDTO;

import java.util.List;

public interface ISurveyAnswer {
    List<SurveyAnswerDTO> findAll();
    SurveyAnswerDTO findById(long id);
    SurveyAnswerDTO save(SurveyAnswerDTO dto);
    void delete(long[] ids);
}
