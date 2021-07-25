package com.springmvcproject.dto;

public class EmployeeDTO extends AbstractDTO<EmployeeDTO> {

    private String name;
    private String phone;
    private Long hospitalId;
    private String hospitalPhone;
    private String hospitalName;

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
    public Long getHospitalId() {
        return hospitalId;
    }
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }
    public String getHospitalPhone() {
        return hospitalPhone;
    }
    public void setHospitalPhone(String hospitalPhone) {
        this.hospitalPhone = hospitalPhone;
    }
        public String getHospitalName() {
        return hospitalName;
    }
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
