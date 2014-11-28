package com.poshbike.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.poshbike.persistance.UserMapper;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
	private UserMapper userMapper;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		if("marissa".equals(username)){
			return new MyUser("marissa","koala");
		}else if("paul".equals(username)){
			return new MyUser("paul","emu");
		}else{
			throw new UsernameNotFoundException("");
		}
	}

}
