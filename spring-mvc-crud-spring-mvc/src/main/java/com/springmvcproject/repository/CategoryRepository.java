package com.springmvcproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvcproject.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findOneByCode(String code);
}
