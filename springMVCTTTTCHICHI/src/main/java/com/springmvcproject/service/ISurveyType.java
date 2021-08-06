package com.springmvcproject.service;

import com.springmvcproject.dto.SurveyTypeDTO;

import java.util.List;

public interface ISurveyType {
    List<SurveyTypeDTO> findAll();
    SurveyTypeDTO findById(long id);
    SurveyTypeDTO save(SurveyTypeDTO dto );
    void delete(long[] ids);
}
