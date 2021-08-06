package com.springmvcproject.service.impl;

import com.springmvcproject.converter.UserConverter;
import com.springmvcproject.dto.UserDTO;
import com.springmvcproject.entity.UserEntity;
import com.springmvcproject.repository.UserRepository;
import com.springmvcproject.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUser {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> models = new ArrayList<>();
        List<UserEntity> entities =userRepository.findAll();
        for (UserEntity item:entities) {
            UserDTO userDTO = userConverter.toDto(item);
            models.add(userDTO);
        }
        return models;
    }
   /* @Override
    public Map<String, String> findAll() {
        Map<String, String> result = new HashMap<>();
        List<UserEntity> entities = newRepository.findAll();
        for (UserEntity item: entities) {
            result.put(item.getFullname(), item.getName());
        }
        return result;
    }*/
    @Override
    public UserDTO findById(long id){
        UserEntity entity=userRepository.findOne(id);
        return userConverter.toDto(entity);
    }

    @Override
    @Transactional
    public UserDTO save(UserDTO dto) {

        UserEntity userEntity = new UserEntity();
        if (dto.getId() != null) {
            UserEntity oldUser = userRepository.findOne(dto.getId());
            //oldNew.setCategory(category);
            userEntity = userConverter.toEntity(oldUser, dto);
        } else {
            userEntity = userConverter.toEntity(dto);
            //newEntity.setCategory(category);
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
