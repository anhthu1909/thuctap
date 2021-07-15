package com.springmvcproject.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "surveyanswer")
public class SurveyAnswerEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;

    @Column(name = "content", columnDefinition = "Clob")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private UserEntity users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveyformid")
    private SurveyFormEntity surveyforms;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }

    public SurveyFormEntity getSurveyforms() {
        return surveyforms;
    }

    public void setSurveyforms(SurveyFormEntity surveyforms) {
        this.surveyforms = surveyforms;
    }

}
