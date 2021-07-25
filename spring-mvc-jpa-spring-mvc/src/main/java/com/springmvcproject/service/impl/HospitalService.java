package com.springmvcproject.service.impl;

import com.springmvcproject.converter.HospitalConverter;
import com.springmvcproject.dto.HospitalDTO;
import com.springmvcproject.entity.HospitalEntity;
import com.springmvcproject.repository.HospitalRepository;
import com.springmvcproject.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HospitalService implements IHospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private HospitalConverter hospitalConverter;

    @Override
    public Map<String, String> findAll() {
        Map<String, String> result = new HashMap<>();
        List<HospitalEntity> entities = hospitalRepository.findAll();
        for (HospitalEntity item: entities) {
            result.put(item.getPhone(), item.getName());
        }
        return result;
    }

    @Override
    public List<HospitalDTO> findAll(Pageable pageable) {
        List<HospitalDTO> models = new ArrayList<>();
        List<HospitalEntity> entities = hospitalRepository.findAll(pageable).getContent();
        for (HospitalEntity item: entities) {
            HospitalDTO hospitalDTO = hospitalConverter.toDto(item);
            models.add(hospitalDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) hospitalRepository.count();
    }

    @Override
    public HospitalDTO findById(long id) {
        HospitalEntity entity = hospitalRepository.findOne(id);
        return hospitalConverter.toDto(entity);
    }

    @Override
    @Transactional
    public HospitalDTO save(HospitalDTO dto) {
        HospitalEntity hospitalEntity = new HospitalEntity();
        if (dto.getId() != null) {
            HospitalEntity oldHospital = hospitalRepository.findOne(dto.getId());
            hospitalEntity = hospitalConverter.toEntity(oldHospital, dto);
        } else {
            hospitalEntity = hospitalConverter.toEntity(dto);
        }
        return hospitalConverter.toDto(hospitalRepository.save(hospitalEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            hospitalRepository.delete(id);
        }
    }
}
