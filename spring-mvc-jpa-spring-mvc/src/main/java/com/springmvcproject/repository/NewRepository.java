package com.springmvcproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvcproject.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
}
