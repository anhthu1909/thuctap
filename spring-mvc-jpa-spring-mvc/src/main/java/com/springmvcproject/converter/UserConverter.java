package com.springmvcproject.converter;

import org.springframework.stereotype.Component;

import com.springmvcproject.dto.UserDTO;
import com.springmvcproject.entity.UserEntity;

@Component
public class UserConverter {

    public UserDTO toDto(UserEntity entity) {
        UserDTO result = new UserDTO();
        result.setId(entity.getId());
        result.setUserName(entity.getUserName());
        result.setPassword(entity.getPassword());
        result.setEmployeeName(entity.getEmployee().getName());
        result.setEmployeePhone(entity.getEmployee().getPhone());
        return result;
    }

    public UserEntity toEntity(UserDTO dto) {
        UserEntity result = new UserEntity();
        result.setUserName(dto.getUserName());
        result.setPassword(dto.getPassword());
        return result;
    }

    public UserEntity toEntity(UserEntity result, UserDTO dto) {
        result.setUserName(dto.getUserName());
        result.setPassword(dto.getPassword());
        return result;
    }
}
