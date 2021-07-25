package com.springmvcproject.service;

import com.springmvcproject.dto.SurveyTypeDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ISurveyTypeService {
    Map<String, String> findAll();
    List<SurveyTypeDTO> findAll(Pageable pageable);
    int getTotalItem();
    SurveyTypeDTO findById(long id);
    SurveyTypeDTO save(SurveyTypeDTO dto);
    void delete(long[] ids);
}
