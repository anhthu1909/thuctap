package com.springmvcproject.service;

import java.util.List;

import com.springmvcproject.dto.NewDTO;

public interface INew {
    List<NewDTO> findAll();
    NewDTO findById(long id);
    NewDTO save(NewDTO dto);
    void delete(long[] ids) ;
}