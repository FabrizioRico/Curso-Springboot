package com.fabrizio.spring.course.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

	@Pointcut("execution(* com.fabrizio.spring.course.aop.service.GreetingService.*(..))")
	public void serviceQuxPointcut() {}
	
	@Pointcut("execution(* com.fabrizio.spring.course.aop.service.GreetingService.*(..))")
	public void servicePointcut() {}
}
