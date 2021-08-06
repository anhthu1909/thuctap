package com.springmvcproject.service;


import java.util.List;

import com.springmvcproject.dto.SurveyFormDTO;


public interface ISurveyForm {
    List<SurveyFormDTO> findAll();
    SurveyFormDTO findById(long id);
    SurveyFormDTO save(SurveyFormDTO dto);
    void delete(long[] id);
}