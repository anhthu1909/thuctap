package com.springmvcproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.springmvcproject.dto.UserDTO;

public interface IUserService {

    Map<String, String> findAll();
    List<UserDTO> findAll(Pageable pageable);
    int getTotalItem();
    UserDTO findById(long id);
    UserDTO save(UserDTO dto);
    void delete(long[] ids);
}
