package com.laptrinhjavaweb.dto;

public class SurveyAnswerDTO extends AbstractDTO<SurveyAnswerDTO> {


    private Long surveyFormId;
    private Long usresId;
    private String usresFullname;
    private String surveyFormContent;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUsresId() {
        return usresId;
    }

    public void setUsresId(Long usresId) {
        this.usresId = usresId;
    }

    public String getUsresFullname() {
        return usresFullname;
    }

    public void setUsresFullname(String usresFullname) {
        this.usresFullname = usresFullname;
    }

    public Long getSurveyFormId() {
        return surveyFormId;
    }

    public void setSurveyFormId(Long surveyFormId) {
        this.surveyFormId = surveyFormId;
    }

    public String getSurveyFormContent() {
        return surveyFormContent;
    }

    public void setSurveyFormContent(String surveyFormContent) {
        this.surveyFormContent = surveyFormContent;
    }

}
