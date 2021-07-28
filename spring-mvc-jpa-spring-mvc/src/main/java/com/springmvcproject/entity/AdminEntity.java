package com.springmvcproject.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
public class AdminEntity extends BaseEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Admin_gen")
    @SequenceGenerator(name="Admin_gen", sequenceName = "Admin_seq", allocationSize=1)
    private Long id;

    @Column(name = "adminName")
    private String adminName;

    @Column(name = "phone", unique = true)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone;

    @Column(name = "password")
    private String password;


    public Long getId() {
        return id;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
