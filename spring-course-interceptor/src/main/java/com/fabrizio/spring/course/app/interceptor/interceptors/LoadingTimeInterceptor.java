package com.fabrizio.spring.course.app.interceptor.interceptors;

import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor{
	
	private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HandlerMethod controller = ((HandlerMethod)handler);
		logger.info("LoadingTimeInterceptor: preHandle() entrando..." + controller.getMethod().getName());
		
		long chronoStart = System.currentTimeMillis();
		request.setAttribute("chronoStart", chronoStart);
		
		Random random = new Random();
		int delay = random.nextInt(500);
		Thread.sleep(delay);
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

		long chronoStart = (long) request.getAttribute("chronoStart");
		long end = System.currentTimeMillis();
		long result = end - chronoStart;
		logger.info("Tiempo transcurrido: " + result + " miliisegundos");
		logger.info("LoadingTimeInterceptor: postHandle() saliendo..." + ((HandlerMethod) handler).getMethod().getName());
	}

}
