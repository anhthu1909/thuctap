package com.springmvcproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="surveyform")
public class SurveyFormEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surveyform_gen")
    @SequenceGenerator(name = "surveyform_gen", sequenceName = "surveyform_seq", allocationSize = 1)
    @Column(name="id")
    private Long id;

    @Column(name="content", columnDefinition = "Clob")
    private String content;

    @OneToMany(mappedBy = "surveyform")
    private List<SurveyAnswerEntity> answers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<SurveyAnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<SurveyAnswerEntity> answers) {
        this.answers = answers;
    }

}
