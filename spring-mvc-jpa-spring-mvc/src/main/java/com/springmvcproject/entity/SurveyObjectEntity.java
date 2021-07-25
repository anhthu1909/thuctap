package com.springmvcproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "surveyobject")
public class SurveyObjectEntity extends BaseEntity{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surveyobject_gen")
    @SequenceGenerator(name = "surveyobject_gen", sequenceName = "surveyobject_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "surveyObject", cascade = CascadeType.ALL)
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
