package com.springmvcproject.converter;

import com.springmvcproject.dto.NewDTO;
import com.springmvcproject.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {
    public NewDTO toDto(NewEntity entity){
        NewDTO result = new NewDTO();
        result.setId(entity.getId());
        result.setTitle(entity.getTitle());
        result.setThumbnail(entity.getThumbnail());
        result.setShortDescription(entity.getShortDescription());
        result.setContent(entity.getContent());
        result.setCategoryCode(entity.getCategory().getCode());
        return result;
    }
    public NewEntity toEntity(NewDTO dto){
        NewEntity result = new NewEntity();
        result.setTitle(dto.getTitle());
        result.setThumbnail(dto.getThumbnail());
        result.setShortDescription(dto.getShortDescription());
        result.setContent(dto.getContent());
        return result;
    }
}
