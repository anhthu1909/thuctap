package com.springmvcproject.converter;

import com.springmvcproject.dto.UserDTO;
import org.springframework.stereotype.Component;

import com.springmvcproject.entity.UserEntity;

@Component
public class UserConverter {

    public UserDTO toDto(UserEntity entity) {
        UserDTO result = new UserDTO();
        result.setId(entity.getId());
        result.setUserName(entity.getUserName());
        result.setPassword(entity.getPassword());
        result.setFullName(entity.getFullName());
        result.setStatus(entity.getStatus());
        return result;
    }

    public UserEntity toEntity(UserDTO dto) {
        UserEntity result = new UserEntity();
        result.setUserName(dto.getUserName());
        result.setPassword(dto.getPassword());
        result.setFullName(dto.getFullName());
        result.setStatus(dto.getStatus());
        return result;
    }

    public UserEntity toEntity(UserEntity result, UserDTO dto) {
        result.setUserName(dto.getUserName());
        result.setPassword(dto.getPassword());
        result.setFullName(dto.getFullName());
        result.setStatus(dto.getStatus());
        return result;
    }
}
