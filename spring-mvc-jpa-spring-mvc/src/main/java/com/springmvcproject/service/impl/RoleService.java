package com.springmvcproject.service.impl;

import com.springmvcproject.converter.RoleConverter;
import com.springmvcproject.dto.RoleDTO;
import com.springmvcproject.entity.RoleEntity;
import com.springmvcproject.repository.RoleRepository;
import com.springmvcproject.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleConverter roleConverter;

    @Override
    public Map<String, String> findAll() {
        Map<String, String> result = new HashMap<>();
        List<RoleEntity> entities = roleRepository.findAll();
        for (RoleEntity item: entities) {
            result.put(item.getCode(), item.getName());
        }
        return result;
    }

    @Override
    public List<RoleDTO> findAll(Pageable pageable) {
        List<RoleDTO> models = new ArrayList<>();
        List<RoleEntity> entities = roleRepository.findAll(pageable).getContent();
        for (RoleEntity item: entities) {
            RoleDTO roleDTO = roleConverter.toDto(item);
            models.add(roleDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) roleRepository.count();
    }

    @Override
    public RoleDTO findById(long id) {
        RoleEntity entity = roleRepository.findOne(id);
        return roleConverter.toDto(entity);
    }

    @Override
    @Transactional
    public RoleDTO save(RoleDTO dto) {
        RoleEntity roleEntity = new RoleEntity();
        if (dto.getId() != null) {
            RoleEntity oldNew = roleRepository.findOne(dto.getId());
            roleEntity = roleConverter.toEntity(oldNew, dto);
        } else {
            roleEntity = roleConverter.toEntity(dto);
        }
        return roleConverter.toDto(roleRepository.save(roleEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            roleRepository.delete(id);
        }
    }
}
