package com.springmvcproject.api.admin;

import com.springmvcproject.dto.SurveyObjectDTO;
import com.springmvcproject.service.ISurveyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "surveyObjectAPIOfAdmin")
public class SurveyObjectAPI {
    @Autowired
    private ISurveyObject surveyObject;
    @PostMapping("/api/doituong")
    public SurveyObjectDTO createNew(@RequestBody SurveyObjectDTO createNew) {
        return surveyObject.save(createNew);
    }

    @PutMapping("/api/doituong")
    public SurveyObjectDTO updateNew(@RequestBody SurveyObjectDTO updateNew) {
        return surveyObject.save(updateNew);
    }

    @DeleteMapping("/api/doituong")
    public void deleteNew(@RequestBody long[] ids) {
        surveyObject.delete(ids);
    }
}