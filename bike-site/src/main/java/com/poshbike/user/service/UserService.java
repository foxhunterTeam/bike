package com.poshbike.user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poshbike.user.entity.User;

public interface UserService {

	public Page<User> findAll(Pageable page);

	public User findById(Long id);

	public User save(User user);

	public void deleteUser(Long id);

}
