package com.springmvcproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "surveyform")
public class SurveyFormEntity extends BaseEntity{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surveyform_gen")
    @SequenceGenerator(name = "surveyform_gen", sequenceName = "surveyform_seq", allocationSize = 1)
    private Long id;

//    @Column(name = "name")
//    private String name;

    @Column(name = "content", columnDefinition = "Clob")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveyobject_id")
    private SurveyObjectEntity surveyObject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveytype_id")
    private SurveyTypeEntity surveyType;


    @OneToMany(mappedBy = "surveyform", cascade = CascadeType.ALL)
    private List<SurveyAnswerEntity> surveyforms = new ArrayList<>();

    public Long getId() { return id; }
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
    public SurveyObjectEntity getSurveyObject() {
        return surveyObject;
    }
    public void setSurveyObject(SurveyObjectEntity surveyObject) {
        this.surveyObject = surveyObject;
    }
    public SurveyTypeEntity getSurveyType() {
        return surveyType;
    }
    public void setSurveyType(SurveyTypeEntity surveyType) {
        this.surveyType = surveyType;
    }
    public List<SurveyAnswerEntity> getSurveyforms() {
        return surveyforms;
    }
    public void setSurveyforms(List<SurveyAnswerEntity> surveyforms) {
        this.surveyforms = surveyforms;
    }
}

