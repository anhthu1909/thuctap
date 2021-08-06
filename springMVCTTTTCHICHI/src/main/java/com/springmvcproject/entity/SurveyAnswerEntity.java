package com.laptrinhjavaweb.entity;

import javax.persistence.*;
@Entity
@Table(name="surveyanswer")
public class SurveyAnswerEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surveyanswer_gen")
    @SequenceGenerator(name = "surveyanswer_gen", sequenceName = "surveyanswer_seq", allocationSize = 1)
    @Column(name="id")
    private Long id;

    @Column(name="content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveyform_id")
    private SurveyFormEntity surveyform;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private UserEntity users;

    public Long getId() {
        return id;
    }

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
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
