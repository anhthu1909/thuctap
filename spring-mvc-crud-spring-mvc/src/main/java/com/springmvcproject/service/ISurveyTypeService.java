package com.springmvcproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.springmvcproject.dto.SurveyTypeDTO;

public interface ISurveyTypeService {
    Map<String, String> findAll();
    List<SurveyTypeDTO> findAll(Pageable pageable);
    int getTotalItem();
    SurveyTypeDTO findById(long id);
    SurveyTypeDTO save(SurveyTypeDTO dto);
    void delete(long[] ids);
}
