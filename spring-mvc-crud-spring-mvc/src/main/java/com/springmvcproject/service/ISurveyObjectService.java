package com.springmvcproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.springmvcproject.dto.SurveyObjectDTO;

public interface ISurveyObjectService {
    Map<String, String> findAll();
    List<SurveyObjectDTO> findAll(Pageable pageable);
    int getTotalItem();
    SurveyObjectDTO findById(long id);
    SurveyObjectDTO save(SurveyObjectDTO dto);
    void delete(long[] ids);
}
