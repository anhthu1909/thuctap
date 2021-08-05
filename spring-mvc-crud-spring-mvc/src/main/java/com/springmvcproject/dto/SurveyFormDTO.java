package com.springmvcproject.dto;

public class SurveyFormDTO extends AbstractDTO<SurveyFormDTO> {

//    private String name;
    private String content;
    private Long surveyObjectId;
    private String surveyObjectName;
    private String surveyObjectCode;
    private Long surveyTypeId;
    private String surveyTypeName;

//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSurveyObjectId() {
        return surveyObjectId;
    }

    public void setSurveyObjectId(Long surveyObjectId) {
        this.surveyObjectId = surveyObjectId;
    }

    public String getSurveyObjectName() {
        return surveyObjectName;
    }

    public void setSurveyObjectName(String surveyObjectName) {
        this.surveyObjectName = surveyObjectName;
    }

    public String getSurveyObjectCode() {
        return surveyObjectCode;
    }

    public void setSurveyObjectCode(String surveyObjectCode) {
        this.surveyObjectCode = surveyObjectCode;
    }

    public Long getSurveyTypeId() {
        return surveyTypeId;
    }

    public void setSurveyTypeId(Long surveyTypeId) {
        this.surveyTypeId = surveyTypeId;
    }

    public String getSurveyTypeName() {
        return surveyTypeName;
    }

    public void setSurveyTypeName(String surveyTypeName) {
        this.surveyTypeName = surveyTypeName;
    }

    public String getSurveyTypeCode() {
        return surveyTypeCode;
    }

    public void setSurveyTypeCode(String surveyTypeCode) {
        this.surveyTypeCode = surveyTypeCode;
    }

    private String surveyTypeCode;

}
