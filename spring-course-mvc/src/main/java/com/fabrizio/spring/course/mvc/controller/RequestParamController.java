package com.fabrizio.spring.course.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabrizio.spring.course.mvc.model.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/param")
public class RequestParamController {
	
	@GetMapping("/baz")
	public ParamDto baz(@RequestParam(required = false, defaultValue = "No message") String message) {
		ParamDto param = new ParamDto();
		
		param.setMessage(message);
		
		return param;
	}
	
	
	@GetMapping("/foo")
	public ParamDto foo(@RequestParam String text) {
		ParamDto param = new ParamDto();
		
		param.setMessage(text);
		
		return param;
	}
	
	@GetMapping("/foo2")
	public ParamDto foo(@RequestParam String text, @RequestParam Integer code) {
		ParamDto param = new ParamDto();
		
		param.setMessage(text);
		param.setCode(code);
		
		return param;
	}
	
	@GetMapping("/request")
	public ParamDto request(HttpServletRequest request) {
		ParamDto param = new ParamDto();
		Integer code = 0;
		try {
			code = Integer.parseInt(request.getParameter("code"));
		} catch (Exception e) {
			e.getMessage();
		}
		param.setCode(code);
		param.setMessage(request.getParameter("message"));
		
		return param;
	}
}
