package com.springmvcproject.api.admin;

import com.springmvcproject.dto.SurveyObjectDTO;
import com.springmvcproject.service.ISurveyObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "surveyObjectAPIOfAdmin")
public class SurveyObjectAPI {

    @Autowired
    private ISurveyObjectService surveyObjectService;

    @PostMapping("/api/surveyObject")
    public SurveyObjectDTO createSurveyObject(@RequestBody SurveyObjectDTO surveyObjectDTO){

        return surveyObjectService.save(surveyObjectDTO);
    }

    @PutMapping ("/api/surveyObject")
    public SurveyObjectDTO updateSurveyObject(@RequestBody SurveyObjectDTO updateSurveyObject){

        return surveyObjectService.save(updateSurveyObject);
    }

    @DeleteMapping("/api/surveyObject")
    public void deleteSurveyObject(@RequestBody long[] ids){
        surveyObjectService.delete(ids);
    }
}
