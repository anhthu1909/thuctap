package com.springmvcproject.api.admin;

import com.springmvcproject.dto.SurveyAnswerDTO;
import com.springmvcproject.service.ISurveyAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "surveyAnswerAPIOfAdmin")
public class SurveyAnswerAPI {
    @Autowired
    private ISurveyAnswer surveyAnswer;
    @PostMapping("/api/answer")
    public SurveyAnswerDTO createNew(@RequestBody SurveyAnswerDTO createNew) {
        return surveyAnswer.save(createNew);
    }

    @PutMapping("/api/answer")
    public SurveyAnswerDTO updateNew(@RequestBody SurveyAnswerDTO updateNew) {
        return surveyAnswer.save(updateNew);
    }

    @DeleteMapping("/api/answer")
    public void deleteNew(@RequestBody long[] ids) {
        surveyAnswer.delete(ids);
    }
}