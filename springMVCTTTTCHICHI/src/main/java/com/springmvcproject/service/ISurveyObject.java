package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.SurveyObjectDTO;

import java.util.List;


public interface ISurveyObject {
    List<SurveyObjectDTO> findAll();
    SurveyObjectDTO findById(long id);
    SurveyObjectDTO save(SurveyObjectDTO dto);
    void delete(long[] ids) ;
}
