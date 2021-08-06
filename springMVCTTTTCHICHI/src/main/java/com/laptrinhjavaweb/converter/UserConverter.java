package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDTO toDto(UserEntity entity)
    {
        UserDTO result=new UserDTO();
        result.setId(entity.getId());
        result.setFullname(entity.getFullname());
        result.setPassword(entity.getPassword());
        result.setStatus(entity.getStatus());
        result.setName(entity.getName());
        return result;
    }
    public UserEntity toEntity(UserDTO dto)
    {
        UserEntity result=new UserEntity();
        result.setFullname(dto.getFullname());
        result.setPassword(dto.getPassword());
        result.setStatus(dto.getStatus());
        result.setName(dto.getName());
        return result;
    }
    public UserEntity toEntity(UserEntity result, UserDTO dto)
    {
        result.setFullname(dto.getFullname());
        result.setPassword(dto.getPassword());
        result.setStatus(dto.getStatus());
        result.setName(dto.getName());
        return result;
    }












}
