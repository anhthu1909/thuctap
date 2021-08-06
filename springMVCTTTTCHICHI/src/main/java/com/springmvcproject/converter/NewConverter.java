package com.springmvcproject.converter;

import com.springmvcproject.dto.NewDTO;
import com.springmvcproject.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {

    public NewDTO toDto(NewEntity entity) {
        NewDTO result = new NewDTO();
        result.setId(entity.getId());
        result.setTitle(entity.getTitle());
        result.setShortDescription(entity.getShortdescription());
        result.setContent(entity.getContent());
        result.setThumbnail(entity.getThumbnail());
        return result;
    }
        public NewEntity toEntity(NewDTO dto) {
            NewEntity result = new NewEntity();
            result.setTitle(dto.getTitle());
            result.setShortdescription(dto.getShortDescription());
            result.setContent(dto.getContent());
            result.setThumbnail(dto.getThumbnail());
            return result;
        }
    public NewEntity toEntity(NewEntity result, NewDTO dto) {
        result.setTitle(dto.getTitle());
        result.setShortdescription(dto.getShortDescription());
        result.setContent(dto.getContent());
        result.setThumbnail(dto.getThumbnail());
        return result;
    }
}
