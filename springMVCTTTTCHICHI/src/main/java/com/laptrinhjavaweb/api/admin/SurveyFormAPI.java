package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.SurveyFormDTO;
import com.laptrinhjavaweb.service.ISurveyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "surveyFormAPIOfAdmin")
public class SurveyFormAPI {
    @Autowired
    private ISurveyForm surveyForm;
    @PostMapping("/api/phieuks")
    public SurveyFormDTO createNew(@RequestBody SurveyFormDTO createNew) {
        return surveyForm.save(createNew);
    }

    @PutMapping("/api/phieuks")
    public SurveyFormDTO updateNew(@RequestBody SurveyFormDTO updateNew) {
        return surveyForm.save(updateNew);
    }

    @DeleteMapping("/api/phieuks")
    public void deleteNew(@RequestBody long[] ids) {
        surveyForm.delete(ids);
    }



}
