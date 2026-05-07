package com.fabrizio.spring.course.error.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

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
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
		return ResponseEntity.internalServerError().body(error);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> numberFormatException(Exception ex){
		Map<String, Object> error = new HashMap<>();
		error.put("date", new Date());
		error.put("error", "no se puede formatear, tipo de dato diferente");
		error.put("message", ex.getMessage());
		error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return error;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Error> notFoundEx(NoHandlerFoundException ex){
		Error error = new Error();
		error.setDate(new Date());
		error.setError("Api Rest no encontrado");
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(404).body(error);
	}
	
}
