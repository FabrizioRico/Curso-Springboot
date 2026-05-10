package com.fabrizio.spring.course.error.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabrizio.spring.course.error.exceptions.UserNotFoundException;
import com.fabrizio.spring.course.error.model.domain.Role;
import com.fabrizio.spring.course.error.model.domain.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private List<User> listUser;

	@Override
	public List<User> findAll() {
		return listUser;
	}

	@Override
	public User findById(Long id) {
		return listUser.stream()
				.filter(u -> u.getId().equals(id))
				.findFirst()
				.map(u -> {
					if (u.getRole() == null) {
						u.setRole(new Role("No tiene un rol asignado"));
					}
					return u;
				})
				.orElseThrow(() -> new UserNotFoundException("El usuario no existe"));
//		for (User u : listUser) {
//			if (u.getId().equals(id)) {
//				user = u;
//				break;
//			}
//		}
//		if (user == null) {
//			throw new UserNotFoundException("El usuario no existe");
//		} else if(user.getRole() == null) {
//			user.setRole(new Role("No tiene un rol asignado"));
//		}
	}
}
