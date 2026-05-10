package com.fabrizio.spring.course.error.exceptions;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message) {
		super(message);
	}	
	
}
