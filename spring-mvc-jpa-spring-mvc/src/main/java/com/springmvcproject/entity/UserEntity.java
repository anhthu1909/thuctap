package com.springmvcproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_gen")
    @SequenceGenerator(name = "users_gen", sequenceName = "users_seq", allocationSize = 1)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "status")
    private Integer status;

    @OneToOne(mappedBy = "user")
    private HospitalEntity hospital;

    @OneToMany(mappedBy = "user")
    private List<UserRoleEntity> userroles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<SurveyAnswerEntity> useranswers = new ArrayList<>();

    public Long getId() { return id; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<UserRoleEntity> getUserrole() {
        return userroles;
    }

    public void setUserrole(List<UserRoleEntity> userrole) {
        this.userroles = userroles;
    }

    public List<SurveyAnswerEntity> getUseranswer() {
        return useranswers;
    }

    public void setUseranswer(List<SurveyAnswerEntity> useranswer) {
        this.useranswers = useranswers;
    }
}
