package com.fabrizio.spring.course.error.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrizio.spring.course.error.exceptions.UserNotFoundException;
import com.fabrizio.spring.course.error.model.domain.User;
import com.fabrizio.spring.course.error.service.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public String index() {
//		int value = 100/0;
		int value = Integer.parseInt("10x");
		System.out.println(value);
		return "ok 200";
	}
	
	@GetMapping("/show/{id}")
	public ResponseEntity<?> show(@PathVariable(name = "id") Long id) {
		User user = service.findById(id);
		System.out.println(user.getLastname());
		
		return ResponseEntity.ok(user);
	}
}
