package com.springmvcproject.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "surveyForm")
public class SurveyFormEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "createddate")
    @CreatedDate
    private Date createdDate;

    @Column(name = "modifieddate")
    @LastModifiedDate
    private Date modifiedDate;

    @Column(name = "createdby")
    @CreatedBy
    private String createdBy;

    @Column(name = "modifiedby")
    @LastModifiedBy
    private String modifiedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveytype_id")
    private SurveyTypeEntity surveytypes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveyobject_id")
    private SurveyObjectEntity surveyobjects;

    @OneToMany(mappedBy = "surveyforms")
    private List<SurveyAnswerEntity> surveyforms = new ArrayList<>();

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public SurveyTypeEntity getSurveytype() {
        return surveytypes;
    }

    public void setSurveytype(SurveyTypeEntity surveytype) {
        this.surveytypes = surveytype;
    }

    public SurveyObjectEntity getSurveyobject() {
        return surveyobjects;
    }

    public void setSurveyobject(SurveyObjectEntity surveyobject) {

        this.surveyobjects = surveyobject;
    }

    public List<SurveyAnswerEntity> getSurveyforms() {
        return surveyforms;
    }

    public void setSurveyforms(List<SurveyAnswerEntity> surveyforms) {
        this.surveyforms = surveyforms;
    }
}

