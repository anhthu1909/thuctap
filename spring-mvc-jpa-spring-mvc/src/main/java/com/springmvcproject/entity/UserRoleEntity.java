package com.springmvcproject.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_role")
public class UserRoleEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ", allocationSize = 1)
    private Long id;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    public Long getId() {
        return id;
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
}
