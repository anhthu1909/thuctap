package com.springmvcproject.converter;

import org.springframework.stereotype.Component;

import com.springmvcproject.dto.EmployeeDTO;
import com.springmvcproject.entity.EmployeeEntity;

@Component
public class EmployeeConverter {

    public EmployeeDTO toDto(EmployeeEntity entity) {
        EmployeeDTO result = new EmployeeDTO();
        result.setId(entity.getId());
        result.setName(entity.getName());
        result.setPhone(entity.getPhone());
        result.setThumbnail(entity.getThumbnail());
        result.setHospitalName(entity.getHospital().getName());
        return result;
    }

    public EmployeeEntity toEntity(EmployeeDTO dto) {
        EmployeeEntity result = new EmployeeEntity();
        result.setName(dto.getName());
        result.setPhone(dto.getPhone());
        result.setThumbnail(dto.getThumbnail());
        return result;
    }

    public EmployeeEntity toEntity(EmployeeEntity result, EmployeeDTO dto) {
        result.setName(dto.getName());
        result.setPhone(dto.getName());
        result.setThumbnail(dto.getThumbnail());
        return result;
    }
}