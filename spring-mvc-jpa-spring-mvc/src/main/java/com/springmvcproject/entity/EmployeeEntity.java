package com.springmvcproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_gen")
    @SequenceGenerator(name = "employee_gen", sequenceName = "employee_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospital;

    @OneToOne(mappedBy = "employee")
    private UserEntity users;

    public Long getId() { return id; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public HospitalEntity getHospital() {
        return hospital;
    }
    public void setHospital(HospitalEntity hospital) {
        this.hospital = hospital;
    }
    public UserEntity getUsers() {
        return users;
    }
    public void setUsers(UserEntity users) {
        this.users = users;
    }
}
