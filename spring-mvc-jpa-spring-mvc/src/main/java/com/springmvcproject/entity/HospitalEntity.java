package com.springmvcproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "hospital")
public class HospitalEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospital_gen")
    @SequenceGenerator(name = "hospital_gen", sequenceName = "hospital_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

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

    public UserEntity getUser() {
        return user;
    }

    public void setUsers(UserEntity user) {
        this.user = user;
    }
}
