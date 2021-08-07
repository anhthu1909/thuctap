package com.springmvcproject.service;

import com.springmvcproject.dto.RoleDTO;

import java.util.List;

public interface IRole {
      List<RoleDTO> findAll();
      RoleDTO findById(long id);
      RoleDTO save(RoleDTO dto);
      void delete(long[] ids);
}
