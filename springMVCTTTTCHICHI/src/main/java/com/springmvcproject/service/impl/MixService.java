package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.MixConventer;
import com.laptrinhjavaweb.dto.MixDTO;
import com.laptrinhjavaweb.entity.MixEntity;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.MixRepository;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IMix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class MixService implements IMix {

    @Autowired
    private MixRepository mixRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MixConventer mixConventer;

    @Override
    public List<MixDTO> findAll() {
        List<MixDTO> models = new ArrayList<>();
        List<MixEntity> entities = mixRepository.findAll();
        for (MixEntity item: entities) {
            MixDTO mixDTO = mixConventer.toDto(item);
            models.add(mixDTO);
        }
        return models;
    }

    @Override
    public MixDTO findById(long id) {
        MixEntity entity = mixRepository.findOne(id);
        return mixConventer.toDto(entity);
    }

    @Override
    @Transactional
    public MixDTO save(MixDTO dto) {
        RoleEntity category = roleRepository.findOneByCode(dto.getRolesCode());
        UserEntity user = userRepository.findOneByFullname(dto.getUsersFullname());
        MixEntity newEntity = new MixEntity();
        if (dto.getId() != null) {
            MixEntity oldNew = mixRepository.findOne(dto.getId());
            oldNew.setRoles(category);
            oldNew.setUsers(user);
            newEntity = mixConventer.toEntity(oldNew, dto);
        } else {
            newEntity = mixConventer.toEntity(dto);
            newEntity.setRoles(category);
            newEntity.setUsers(user);
        }
        return mixConventer.toDto(mixRepository.save(newEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            mixRepository.delete(id);
        }
    }
}
