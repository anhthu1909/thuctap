package com.springmvcproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_role")
public class UserRoleEntity extends BaseEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_gen")
    @SequenceGenerator(name = "user_role_gen", sequenceName = "user_role_seq", allocationSize = 1)
    private Long id;

    @Column(name = "code")
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @OneToMany(mappedBy = "userrole", cascade = CascadeType.ALL)
    private List<SurveyAnswerEntity> useranswers = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public UserEntity getUsers() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
    public RoleEntity getRole() {
        return role;
    }
    public void setRole(RoleEntity role) {
        this.role = role;
    }
    public List<SurveyAnswerEntity> getUseranswer() {
        return useranswers;
    }
    public void setUseranswer(List<SurveyAnswerEntity> useranswer) {
        this.useranswers = useranswers;
    }
}
