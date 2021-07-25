package com.springmvcproject.service;

import com.springmvcproject.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IUserService {
    Map<String, String> findAll();
    List<UserDTO> findAll(Pageable pageable);
    int getTotalItem();
    UserDTO findById(long id);
    UserDTO save(UserDTO dto);
    void delete(long[] ids);
}
