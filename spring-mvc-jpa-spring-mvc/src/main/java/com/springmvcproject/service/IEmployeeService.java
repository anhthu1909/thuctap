package com.springmvcproject.service;

import com.springmvcproject.dto.EmployeeDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDTO> findAll(Pageable pageable);
    int getTotalItem();
    EmployeeDTO findById(long id);
    EmployeeDTO save(EmployeeDTO dto);
    void delete(long[] ids);
}
