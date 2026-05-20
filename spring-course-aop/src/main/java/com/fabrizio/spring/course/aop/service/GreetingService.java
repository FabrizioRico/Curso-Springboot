package com.fabrizio.spring.course.aop.service;

public interface GreetingService {

	String greet(String person, String phrase);
	
	String greetError(String person, String phrase);
}
