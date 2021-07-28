package com.springmvcproject.repository;

import com.springmvcproject.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
    AdminEntity findOneByPhone(String phone);
}
