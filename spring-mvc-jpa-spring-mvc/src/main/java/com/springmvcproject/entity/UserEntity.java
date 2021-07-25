package com.springmvcproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_gen")
    @SequenceGenerator(name = "users_gen", sequenceName = "users_seq", allocationSize = 1)
    private Long id;

    @Column(name = "username", unique = true)
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToOne
    @MapsId
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserRoleEntity> userroles = new ArrayList<>();

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
    public EmployeeEntity getEmployee() {
        return employee;
    }
    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
    public List<UserRoleEntity> getUserrole() {
        return userroles;
    }
    public void setUserrole(List<UserRoleEntity> userrole) {
        this.userroles = userroles;
    }
}
