package com.fabrizio.spring.course.aop.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrizio.spring.course.aop.service.GreetingService;

@RestController
public class GreetingController {

	@Autowired
	private GreetingService greetingService;

	@GetMapping("/greet")
	public ResponseEntity<?> greeting(){
		return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.greet("Fabrizio", "Buenos dias!")));
	}
	
	@GetMapping("/greetError")
	public ResponseEntity<?> greetingError(){
		return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.greetError("Fabrizio", "Buenos dias!")));
	}
}
