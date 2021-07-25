package com.springmvcproject.dto;

public class UserDTO extends AbstractDTO<UserDTO> {

    private String userName;
    private String password;
    private Long employeeId;
    private String employeeName;
    private String employeePhone;

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
    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getEmployeePhone() {
        return employeePhone;
    }
    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }
}
