package com.springmvcproject.service.impl;

import com.springmvcproject.converter.UserConverter;
import com.springmvcproject.dto.UserDTO;
import com.springmvcproject.entity.EmployeeEntity;
import com.springmvcproject.entity.UserEntity;
import com.springmvcproject.repository.EmployeeRepository;
import com.springmvcproject.repository.UserRepository;
import com.springmvcproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public Map<String, String> findAll() {
        Map<String, String> result = new HashMap<>();
        List<UserEntity> entities = userRepository.findAll();
        for (UserEntity item: entities) {
            result.put(item.getUserName(), item.getPassword());
        }
        return result;
    }

    @Override
    public List<UserDTO> findAll(Pageable pageable) {
        List<UserDTO> models = new ArrayList<>();
        List<UserEntity> entities = userRepository.findAll(pageable).getContent();
        for (UserEntity item: entities) {
            UserDTO userDTO = userConverter.toDto(item);
            models.add(userDTO);
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) userRepository.count();
    }

    @Override
    public UserDTO findById(long id) {
        UserEntity entity = userRepository.findOne(id);
        return userConverter.toDto(entity);
    }

    @Override
    @Transactional
    public UserDTO save(UserDTO dto) {
        EmployeeEntity employee = employeeRepository.findOneByPhone(dto.getEmployeePhone());
        UserEntity userEntity = new UserEntity();
        if (dto.getId() != null) {
            UserEntity oldUser = userRepository.findOne(dto.getId());
            oldUser.setEmployee(employee);
            userEntity = userConverter.toEntity(oldUser, dto);
        } else {
            userEntity = userConverter.toEntity(dto);
            userEntity.setEmployee(employee);
        }
        return userConverter.toDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            userRepository.delete(id);
        }
    }
}
