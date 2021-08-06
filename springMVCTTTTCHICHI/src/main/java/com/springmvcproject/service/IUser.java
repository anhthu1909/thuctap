package com.springmvcproject.service;

import com.springmvcproject.dto.UserDTO;

import java.util.List;

public interface IUser  {
       List<UserDTO> findAll();
       UserDTO findById(long id);
       UserDTO save(UserDTO dto);
       void delete(long[] ids);

}
