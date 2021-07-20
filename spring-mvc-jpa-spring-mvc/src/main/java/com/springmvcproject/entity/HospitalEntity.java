package com.springmvcproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospital")
public class HospitalEntity extends BaseEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospital_gen")
    @SequenceGenerator(name = "hospital_gen", sequenceName = "hospital_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<EmployeeEntity> employees = new ArrayList<>();

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
    public List<EmployeeEntity> getEmployees() {
        return employees;
    }
    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
