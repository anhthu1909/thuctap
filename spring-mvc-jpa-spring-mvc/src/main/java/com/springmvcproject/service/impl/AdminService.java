package com.springmvcproject.service.impl;

import com.springmvcproject.converter.AdminConverter;
import com.springmvcproject.dto.AdminDTO;
import com.springmvcproject.entity.AdminEntity;
import com.springmvcproject.repository.AdminRepository;
import com.springmvcproject.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminConverter adminConverter;

    @Override
    public Map<String, String> findAll() {
        Map<String, String> result = new HashMap<>();
        List<AdminEntity> entities = adminRepository.findAll();
        for (AdminEntity item: entities) {
            result.put(item.getPhone(), item.getAdminName());
        }
        return result;
    }

    @Override
    public List<AdminDTO> findAll(Pageable pageable) {
        List<AdminDTO> models = new ArrayList<>();
        List<AdminEntity> entities = adminRepository.findAll(pageable).getContent();
        for (AdminEntity item: entities) {
            AdminDTO adminDTO = adminConverter.toDto(item);
            models.add(adminDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) adminRepository.count();
    }

    @Override
    public AdminDTO findById(long id) {
        AdminEntity entity = adminRepository.findOne(id);
        return adminConverter.toDto(entity);
    }

    @Override
    @Transactional
    public AdminDTO save(AdminDTO dto) {
        AdminEntity adminEntity = new AdminEntity();
        if (dto.getId() != null) {
            AdminEntity oldAdmin = adminRepository.findOne(dto.getId());
            adminEntity = adminConverter.toEntity(oldAdmin, dto);
        } else {
            adminEntity = adminConverter.toEntity(dto);
        }
        return adminConverter.toDto(adminRepository.save(adminEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            adminRepository.delete(id);
        }
    }
}
