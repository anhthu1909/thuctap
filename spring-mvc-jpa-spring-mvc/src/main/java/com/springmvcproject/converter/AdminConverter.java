package com.springmvcproject.converter;

import com.springmvcproject.dto.AdminDTO;
import com.springmvcproject.entity.AdminEntity;
import org.springframework.stereotype.Component;

@Component
public class AdminConverter {

    public AdminDTO toDto(AdminEntity entity) {
        AdminDTO result = new AdminDTO();
        result.setId(entity.getId());
        result.setAdminName(entity.getAdminName());
        result.setPhone(entity.getPhone());
        result.setPassword(entity.getPassword());
        return result;
    }

    public AdminEntity toEntity(AdminDTO dto) {
        AdminEntity result = new AdminEntity();
        result.setAdminName(dto.getAdminName());
        result.setPhone(dto.getPhone());
        result.setPassword(dto.getPassword());
        return result;
    }

    public AdminEntity toEntity(AdminEntity result, AdminDTO dto) {
        result.setAdminName(dto.getAdminName());
        result.setPhone(dto.getPhone());
        result.setPassword(dto.getPassword());
        return result;
    }
}
