package com.fabrizio.spring.course.error.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fabrizio.spring.course.error.model.domain.User;

@Service
public class UserServiceImpl implements UserService{
	
	private List<User> listUser;
	
	public UserServiceImpl() {
		this.listUser = new ArrayList<>();
		listUser.add(new User(1L, "Fabrizio", "Risco"));
		listUser.add(new User(2L, "Dexter", "Morgan"));
		listUser.add(new User(3L, "David", "Bowiw"));
		listUser.add(new User(4L, "Trent", "Reznor"));
	}

	@Override
	public List<User> findAll() {
		return listUser;
	}

	@Override
	public User findById(Long id) {
		User userI = null;
		for (User user : listUser) {
			if (user.getId().equals(id)) {
				userI = user;
				break;
			}
		}
		return userI;
	}

}
