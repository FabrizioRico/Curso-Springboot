package com.fabrizio.spring.course.error.service;

import java.util.List;

import com.fabrizio.spring.course.error.model.domain.User;

public interface UserService {

	List<User> findAll();
	User findById(Long id);
}
