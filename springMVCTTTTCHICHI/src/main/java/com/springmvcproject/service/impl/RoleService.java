package com.springmvcproject.service.impl;


import com.springmvcproject.converter.RoleConverter;
import com.springmvcproject.dto.RoleDTO;
import com.springmvcproject.entity.RoleEntity;
import com.springmvcproject.repository.RoleRepository;
import com.springmvcproject.service.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public  class RoleService implements IRole {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleConverter roleConverter;

    @Override
    public List<RoleDTO> findAll() {
        List<RoleDTO> models = new ArrayList<>();
        List<RoleEntity> entities =roleRepository.findAll();
        for (RoleEntity item:entities) {
            RoleDTO roleDTO = roleConverter.toDto(item);
            models.add(roleDTO);
        }
        return models;
    }

    @Override
    public RoleDTO findById(long id){
        RoleEntity entity=roleRepository.findOne(id);
        return roleConverter.toDto(entity);
    }

    @Override
    @Transactional
    public RoleDTO save(RoleDTO dto) {

        RoleEntity roleEntity = new RoleEntity();
        if (dto.getId() != null) {
            RoleEntity oldRole = roleRepository.findOne(dto.getId());
            roleEntity = roleConverter.toEntity(oldRole, dto);
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
