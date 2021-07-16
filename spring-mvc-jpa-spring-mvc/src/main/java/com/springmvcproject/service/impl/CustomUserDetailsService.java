package com.springmvcproject.service.impl;

import com.springmvcproject.constant.SystemConstant;
import com.springmvcproject.dto.MyUser;
import com.springmvcproject.entity.RoleEntity;
import com.springmvcproject.entity.UserEntity;
import com.springmvcproject.entity.UserRoleEntity;
import com.springmvcproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);

		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (UserRoleEntity role: userEntity.getUserrole()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(),
							true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		return myUser;
	}

}
