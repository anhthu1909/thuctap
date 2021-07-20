package com.springmvcproject.service;

import com.springmvcproject.dto.CategoryDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ICategoryService {
	Map<String, String> findAll();
	List<CategoryDTO> findAll(Pageable pageable);
	int getTotalItem();
	CategoryDTO findById(long id);
	CategoryDTO save(CategoryDTO dto);
	void delete(long[] ids);
}
