package com.springmvcproject.service;

import com.springmvcproject.dto.AdminDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IAdminService {
    Map<String, String> findAll();
    List<AdminDTO> findAll(Pageable pageable);
    int getTotalItem();
    AdminDTO findById(long id);
    AdminDTO save(AdminDTO dto);
    void delete(long[] ids);
}
