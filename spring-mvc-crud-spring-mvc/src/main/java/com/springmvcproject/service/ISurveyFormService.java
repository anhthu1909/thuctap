package com.springmvcproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.springmvcproject.dto.SurveyFormDTO;

public interface ISurveyFormService {
    Map<String, String> findAll();
    List<SurveyFormDTO> findAll(Pageable pageable);
    int getTotalItem();
    SurveyFormDTO findById(long id);
    SurveyFormDTO save(SurveyFormDTO dto);
    void delete(long[] ids);
}
