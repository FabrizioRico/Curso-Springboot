package com.fabrizio.spring.course.error.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.fabrizio.spring.course.error.model.Error;

@RestControllerAdvice
public class HandlerExceptionController {

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<?> divisionByZero(Exception ex){
		Error error = new Error();
		error.setDate(new Date());
		error.setError("Error de division por cero");
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
//		return ResponseEntity.internalServerError().body(error);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.body(error);
	}
}
