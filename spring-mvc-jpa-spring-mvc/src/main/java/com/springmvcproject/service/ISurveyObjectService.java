package com.springmvcproject.service;

import com.springmvcproject.dto.SurveyObjectDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ISurveyObjectService {
    Map<String, String> findAll();
    List<SurveyObjectDTO> findAll(Pageable pageable);
    int getTotalItem();
    SurveyObjectDTO findById(long id);
    SurveyObjectDTO save(SurveyObjectDTO dto);
    void delete(long[] ids);
}
