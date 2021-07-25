package com.springmvcproject.repository;

import com.springmvcproject.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findOneByPhone(String phone);
}
