package com.springmvcproject.service;

import com.springmvcproject.dto.MixDTO;

import java.util.List;

public interface IMix  {
    List<MixDTO> findAll();
    MixDTO findById(long id);
    MixDTO save(MixDTO dto);
    void delete(long[] ids);
}
