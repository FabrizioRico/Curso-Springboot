package com.fabrizio.spring.course.aop.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{

	@Override
	public String greet(String person, String phrase) {
		String greeting = phrase + " " + person;
		System.out.println(greeting);
		
		return greeting;
	}

	@Override
	public String greetError(String person, String phrase) {
		throw new RuntimeException("Un error");
	}

	
}
