package com.springmvcproject.converter;

import com.springmvcproject.dto.MixDTO;
import com.springmvcproject.entity.MixEntity;
import org.springframework.stereotype.Component;

@Component
public class MixConventer  {
    public MixDTO toDto(MixEntity entity) {
        MixDTO result = new MixDTO();
        result.setId(entity.getId());
        result.setRolesCode(entity.getRoles().getCode());
        result.setUsersFullname(entity.getUsers().getFullname());

        return result;
    }
    public MixEntity toEntity(MixDTO dto) {

        return  null;

    }
    public MixEntity toEntity(MixEntity result,MixDTO dto){

        return null;


    }
}
