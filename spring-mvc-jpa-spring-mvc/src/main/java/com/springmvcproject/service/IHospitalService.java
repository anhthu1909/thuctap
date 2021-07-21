package com.springmvcproject.service;

import com.springmvcproject.dto.HospitalDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IHospitalService {
    Map<String, String> findAll();
    List<HospitalDTO> findAll(Pageable pageable);
    int getTotalItem();
    HospitalDTO findById(long id);
    HospitalDTO save(HospitalDTO dto);
    void delete(long[] ids);
}
