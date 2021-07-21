package com.springmvcproject.converter;

import com.springmvcproject.dto.HospitalDTO;
import com.springmvcproject.entity.HospitalEntity;
import org.springframework.stereotype.Component;

@Component
public class HospitalConverter {

    public HospitalDTO toDto(HospitalEntity entity) {
        HospitalDTO result = new HospitalDTO();
        result.setId(entity.getId());
        result.setName(entity.getName());
        result.setPhone(entity.getPhone());
        return result;
    }

    public HospitalEntity toEntity(HospitalDTO dto) {
        HospitalEntity result = new HospitalEntity();
        result.setName(dto.getName());
        result.setPhone(dto.getPhone());
        return result;
    }

    public HospitalEntity toEntity(HospitalEntity result, HospitalDTO dto) {
        result.setName(dto.getName());
        result.setPhone(dto.getPhone());
        return result;
    }
}
