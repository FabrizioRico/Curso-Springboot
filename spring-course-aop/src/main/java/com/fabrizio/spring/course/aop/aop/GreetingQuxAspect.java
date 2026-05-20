package com.fabrizio.spring.course.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class GreetingQuxAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before("GreetingServicePointcuts.serviceQuxPointcut()")
	public void loggerBefore(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		
		logger.info("Aspecto ejecutado antes de: " + method + " con los argumentos " + args);
	}
	
	@After("GreetingServicePointcuts.serviceQuxPointcut()")
	public void loggerAfter(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		
		logger.info("Aspecto ejecutado despues de: " + method + " con los argumentos " + args);
	}
}
