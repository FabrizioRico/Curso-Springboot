package com.fabrizio.spring.course.mvc.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrizio.spring.course.mvc.model.User;
import com.fabrizio.spring.course.mvc.model.dto.UserDto;
import com.fabrizio.spring.course.mvc.model.dto.UserDto2;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@GetMapping("/restdetailsmap")
	public Map<String, Object> detailsMap() {
		Map<String, Object> data = new HashMap<>();
		
		data.put("name", "Fabrizio Omar");
		data.put("lastname", "Risco Alva");
		
		User user = new User("Fabrizio", "Risco");
		data.put("user", user);
		
		return data;
	}
	
	@GetMapping("/restdetailsdto")
	public UserDto details2() {
		UserDto userDto = new UserDto();
		User user = new User("Trent","Reznor");
		
		userDto.setTitle("Rest con DTO");
		userDto.setUser(user);
		
		return userDto;
	}
	
	@GetMapping("/restdetailsdto2")
	public UserDto2 details3() {
		UserDto2 userDto = new UserDto2();
		User user = new User("Eddie","Dark");
		
		userDto.setTitle("Rest con DTO pero diferente");
		userDto.setUser(user.getName());
		userDto.setLastname(user.getLastname());
		userDto.setFullname(user.getName() + " " +user.getLastname());
		
		return userDto;
	}
	
	@GetMapping("/restdetailslist")
	public List<User> listUser(){
		User user1 = new User("Eddie","Dark");
		User user2 = new User("Trent","Reznor");
		User user3 = new User("Fabrizio", "Risco");
		
//		List<User> users = new ArrayList<>();
//		users.add(user3);
//		users.add(user2);
//		users.add(user1);
		
		List<User> users = Arrays.asList(user1, user2, user3);
		
		return users;
	}
}
