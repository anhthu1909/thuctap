package com.springmvcproject.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hospital")
public class HospitalEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "createddate")
    @CreatedDate
    private Date createdDate;

    @Column(name = "modifieddate")
    @LastModifiedDate
    private Date modifiedDate;

    @Column(name = "createdby")
    @CreatedBy
    private String createdBy;

    @Column(name = "modifiedby")
    @LastModifiedBy
    private String modifiedBy;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUsers(UserEntity user) {
        this.user = user;
    }
}
