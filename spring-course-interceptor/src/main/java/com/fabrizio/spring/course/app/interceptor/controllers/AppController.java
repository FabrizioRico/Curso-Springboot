package com.fabrizio.spring.course.app.interceptor.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

	@GetMapping("/fooTest")
	public Map<String, Object> fooTest(){
		
		return Collections.singletonMap("message", "handler foo del controlador");
	}
	
	@GetMapping("/quxTest")
	public Map<String, Object> quxTest(){
		
		return Collections.singletonMap("message", "handler qux del controlador");
	}
	
	@GetMapping("/barTest")
	public Map<String, Object> barTest(){
		
		return Collections.singletonMap("message", "handler bar del controlador");
	}
	
	
}
