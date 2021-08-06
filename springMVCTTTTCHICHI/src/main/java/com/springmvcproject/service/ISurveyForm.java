package com.laptrinhjavaweb.service;


import java.util.List;

import com.laptrinhjavaweb.dto.SurveyFormDTO;


public interface ISurveyForm {
    List<SurveyFormDTO> findAll();
    SurveyFormDTO findById(long id);
    SurveyFormDTO save(SurveyFormDTO dto);
    void delete(long[] id);
}