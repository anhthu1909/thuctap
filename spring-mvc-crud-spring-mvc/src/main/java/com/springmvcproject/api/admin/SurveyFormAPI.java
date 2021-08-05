package com.springmvcproject.api.admin;

import com.springmvcproject.dto.SurveyFormDTO;
import com.springmvcproject.service.ISurveyFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "surveyFormAPIOfAdmin")
public class SurveyFormAPI {

    @Autowired
    private ISurveyFormService surveyFormService;

    @PostMapping("/api/surveyForm")
    public SurveyFormDTO createSurveyForm(@RequestBody SurveyFormDTO surveyFormDTO){

        return surveyFormService.save(surveyFormDTO);
    }

    @PutMapping ("/api/surveyForm")
    public SurveyFormDTO updateSurveyForm(@RequestBody SurveyFormDTO updateSurveyForm){

        return surveyFormService.save(updateSurveyForm);
    }

    @DeleteMapping("/api/surveyForm")
    public void deleteSurveyForm(@RequestBody long[] ids){
        surveyFormService.delete(ids);
    }
}
