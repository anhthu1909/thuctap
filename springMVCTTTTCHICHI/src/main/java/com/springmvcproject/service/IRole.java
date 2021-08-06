package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.RoleDTO;

import java.util.List;
import java.util.Map;

public interface IRole {

     // Map<String> findAll();
      List<RoleDTO> findAll();
      RoleDTO findById(long id);
      RoleDTO save(RoleDTO dto);
      void delete(long[] ids);
}
