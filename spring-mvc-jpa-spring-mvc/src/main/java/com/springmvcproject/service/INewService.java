package com.springmvcproject.service;

import com.springmvcproject.dto.NewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewService {
    List<NewDTO> findAll(Pageable pageable);
    int getTotalItem();
}
