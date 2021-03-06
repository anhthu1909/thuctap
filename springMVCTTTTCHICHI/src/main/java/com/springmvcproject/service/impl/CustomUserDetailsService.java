package com.springmvcproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springmvcproject.constant.SystemConstant;
import com.springmvcproject.dto.MyUser;
import com.springmvcproject.entity.RoleEntity;
import com.springmvcproject.entity.UserEntity;
import com.springmvcproject.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByNameAndStatus(name, SystemConstant.ACTIVE_STATUS);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (RoleEntity role: userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        MyUser myUser = new MyUser(userEntity.getName(), userEntity.getPassword(),
                true, true, true, true, authorities);
        myUser.setFullName(userEntity.getFullname());
        return myUser;
    }
}
