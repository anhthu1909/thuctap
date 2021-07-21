package com.springmvcproject.dto;

public class EmployeeDTO extends AbstractDTO<EmployeeDTO> {

    private String name;
    private String thumbnail;
    private String phone;
    private Long hospitalId;
    private String hospitalCode;
    private String hospitalName;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Long getHospitalId() {
        return hospitalId;
    }
    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }
    public String getHospitalCode() {
        return hospitalCode;
    }
    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }
    public String getHospitalName() {
        return hospitalName;
    }
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
