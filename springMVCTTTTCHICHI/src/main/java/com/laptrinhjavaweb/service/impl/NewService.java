package com.laptrinhjavaweb.service.impl;


import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public  class NewService implements INew {
	@Autowired
    private NewRepository newRepository;
	@Autowired
	private NewConverter newConverter;

	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities =newRepository.findAll();
		for (NewEntity item:entities) {
			NewDTO newDTO = newConverter.toDto(item);
			models.add(newDTO);
		}
		return models;
	}
	@Override
	public NewDTO findById(long id){
		NewEntity entity=newRepository.findOne(id);
		return newConverter.toDto(entity);
	}

	@Override
	@Transactional
	public NewDTO save(NewDTO dto) {

		NewEntity newEntity = new NewEntity();
		if (dto.getId() != null) {
			NewEntity oldNew = newRepository.findOne(dto.getId());
			// oldNew.setCategory(category);
			newEntity = newConverter.toEntity(oldNew, dto);
		} else {
			newEntity = newConverter.toEntity(dto);
			//newEntity.setCategory(category);
		}
		return newConverter.toDto(newRepository.save(newEntity));
	}


    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            newRepository.delete(id);
        }
    }

}
