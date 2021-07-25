package com.springmvcproject.service;

import com.springmvcproject.dto.EmployeeDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    Map<String, String> findAll();
    List<EmployeeDTO> findAll(Pageable pageable);
    int getTotalItem();
    EmployeeDTO findById(long id);
    EmployeeDTO save(EmployeeDTO dto);
    void delete(long[] ids);
}
