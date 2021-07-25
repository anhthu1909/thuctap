package com.springmvcproject.repository;

import com.springmvcproject.entity.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<HospitalEntity, Long> {
    HospitalEntity findOneByPhone(String phone);
}
