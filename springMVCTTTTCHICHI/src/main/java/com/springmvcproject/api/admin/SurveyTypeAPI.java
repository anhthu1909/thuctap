package com.springmvcproject.api.admin;

import com.springmvcproject.dto.SurveyTypeDTO;
import com.springmvcproject.service.ISurveyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "surveyTypeAPIOfAdmin")
public class SurveyTypeAPI {
    @Autowired
    private ISurveyType surveyType;
    @PostMapping("/api/kieu")
    public SurveyTypeDTO createNew(@RequestBody SurveyTypeDTO createNew) {
        return surveyType.save(createNew);
    }

    @PutMapping("/api/kieu")
    public SurveyTypeDTO updateNew(@RequestBody SurveyTypeDTO updateNew) {
        return surveyType.save(updateNew);
    }

    @DeleteMapping("/api/kieu")
    public void deleteNew(@RequestBody long[] ids) {
        surveyType.delete(ids);
    }
}