package com.springmvcproject.api.admin;

import com.springmvcproject.dto.SurveyTypeDTO;
import com.springmvcproject.service.ISurveyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "surveyTypeAPIOfAdmin")
public class SurveyTypeAPI {

    @Autowired
    private ISurveyTypeService surveyTypeService;

    @PostMapping("/api/surveyType")
    public SurveyTypeDTO createSurveyType(@RequestBody SurveyTypeDTO surveyTypeDTO){

        return surveyTypeService.save(surveyTypeDTO);
    }

    @PutMapping ("/api/surveyType")
    public SurveyTypeDTO updateSurveyType(@RequestBody SurveyTypeDTO updateSurveyType){

        return surveyTypeService.save(updateSurveyType);
    }

    @DeleteMapping("/api/surveyType")
    public void deleteSurveyType(@RequestBody long[] ids){
        surveyTypeService.delete(ids);
    }
}
