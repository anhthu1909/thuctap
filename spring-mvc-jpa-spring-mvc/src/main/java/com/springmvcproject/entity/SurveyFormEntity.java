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

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveytype_id")
    private SurveyTypeEntity surveytype;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveyobject_id")
    private SurveyObjectEntity surveyobject;

    @OneToMany(mappedBy = "surveyform", cascade = CascadeType.ALL)
    private List<SurveyAnswerEntity> surveyforms = new ArrayList<>();

    public Long getId() { return id; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public SurveyTypeEntity getSurveytype() {
        return surveytype;
    }
    public void setSurveytype(SurveyTypeEntity surveytype) {
        this.surveytype = surveytype;
    }
    public SurveyObjectEntity getSurveyobject() {
        return surveyobject;
    }
    public void setSurveyobject(SurveyObjectEntity surveyobject) { this.surveyobject = surveyobject; }
    public List<SurveyAnswerEntity> getSurveyforms() {
        return surveyforms;
    }
    public void setSurveyforms(List<SurveyAnswerEntity> surveyforms) {
        this.surveyforms = surveyforms;
    }
}

