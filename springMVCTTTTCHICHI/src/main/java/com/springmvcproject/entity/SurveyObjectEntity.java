package com.springmvcproject.entity;

import javax.persistence.*;
@Entity
@Table(name="surveyobject")
public class SurveyObjectEntity extends BaseEntity {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surveyobject_gen")
    @SequenceGenerator(name = "surveyobject_gen", sequenceName = "surveyobject_seq", allocationSize = 1)
    private Long id;

    @Column(name="name")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
