package com.springmvcproject.service.impl;

import com.springmvcproject.converter.EmployeeConverter;
import com.springmvcproject.dto.EmployeeDTO;
import com.springmvcproject.entity.EmployeeEntity;
import com.springmvcproject.entity.HospitalEntity;
import com.springmvcproject.repository.EmployeeRepository;
import com.springmvcproject.repository.HospitalRepository;
import com.springmvcproject.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Override
    public List<EmployeeDTO> findAll(Pageable pageable) {
        List<EmployeeDTO> models = new ArrayList<>();
        List<EmployeeEntity> entities = employeeRepository.findAll(pageable).getContent();
        for (EmployeeEntity item: entities) {
            EmployeeDTO employeeDTO = employeeConverter.toDto(item);
            models.add(employeeDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) employeeRepository.count();
    }

    @Override
    public EmployeeDTO findById(long id) {
        EmployeeEntity entity = employeeRepository.findOne(id);
        return employeeConverter.toDto(entity);
    }

    @Override
    @Transactional
    public EmployeeDTO save(EmployeeDTO dto) {
        HospitalEntity hospital = hospitalRepository.findOneByCode(dto.getHospitalCode());
        EmployeeEntity employeeEntity = new EmployeeEntity();
        if (dto.getId() != null) {
            EmployeeEntity oldEmployee = employeeRepository.findOne(dto.getId());
            oldEmployee.setHospital(hospital);
            employeeEntity = employeeConverter.toEntity(oldEmployee, dto);
        } else {
            employeeEntity = employeeConverter.toEntity(dto);
            employeeEntity.setHospital(hospital);
        }
        return employeeConverter.toDto(employeeRepository.save(employeeEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            employeeRepository.delete(id);
        }
    }
}
