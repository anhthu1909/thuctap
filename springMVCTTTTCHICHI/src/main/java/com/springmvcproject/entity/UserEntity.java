package com.springmvcproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_gen")
    @SequenceGenerator(name = "users_gen", sequenceName = "users_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "status")
    private Integer status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "usersid"),
            inverseJoinColumns = @JoinColumn(name = "rolesid"))
    private List<RoleEntity> roles = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<MixEntity> mixs = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<SurveyAnswerEntity> answers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public List<MixEntity> getMixs() {
        return mixs;
    }

    public void setMixs(List<MixEntity> mixs) {
        this.mixs = mixs;
    }

    public List<SurveyAnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<SurveyAnswerEntity> answers) {
        this.answers = answers;
    }
}
