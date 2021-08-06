package com.laptrinhjavaweb.entity;

import javax.persistence.*;
@Entity
@Table(name="surveytype")
public class SurveyTypeEntity extends BaseEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surveytype_gen")
    @SequenceGenerator(name = "surveytype_gen", sequenceName = "surveytype_seq", allocationSize = 1)

    @Column(name="id")

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
