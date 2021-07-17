package com.springmvcproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "surveytype")
public class SurveyTypeEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surveytype-gen")
    @SequenceGenerator(name = "surveytype_gen", sequenceName = "surveytype_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "surveytype")
    private List<SurveyFormEntity> surveyforms = new ArrayList<>();

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

    public List<SurveyFormEntity> getSurveyforms() {
        return surveyforms;
    }

    public void setSurveyforms(List<SurveyFormEntity> surveyforms) {
        this.surveyforms = surveyforms;
    }
}
