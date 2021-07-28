package com.springmvcproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "surveyanswer")
public class SurveyAnswerEntity extends BaseEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surveyanswer_gen")
    @SequenceGenerator(name = "surveyanswer_gen", sequenceName = "surveyanswer_seq", allocationSize = 1)
    private Long id;

    @Column(name = "content", columnDefinition = "Clob")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveyform_id")
    private SurveyFormEntity surveyform;

    public Long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public SurveyFormEntity getSurveyform() {
        return surveyform;
    }
    public void setSurveyform(SurveyFormEntity surveyform) {
        this.surveyform = surveyform;
    }
}
