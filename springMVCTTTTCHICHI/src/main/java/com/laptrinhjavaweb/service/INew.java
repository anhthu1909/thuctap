package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.NewDTO;

public interface INew {
    List<NewDTO> findAll();
    NewDTO findById(long id);
    NewDTO save(NewDTO dto);
    void delete(long[] ids) ;
}