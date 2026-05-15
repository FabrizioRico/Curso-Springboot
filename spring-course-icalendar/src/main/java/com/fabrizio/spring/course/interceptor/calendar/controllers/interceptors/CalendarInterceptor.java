package com.fabrizio.spring.course.interceptor.calendar.controllers.interceptors;

import java.util.Calendar;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CalendarInterceptor implements HandlerInterceptor{
	
	@Value("${config.calendar.open}")
	private Integer open;
	@Value("${config.calendar.open}")
	private Integer close;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		
		if(hour >= open && hour < close) {
			StringBuilder message = new StringBuilder("Bienvenidos a atencion al cliente");
			message.append(", atendemos desde las");
			message.append(open);
			message.append(" horas hasta las ");
			message.append(close);
			message.append(" horas.");
			request.setAttribute("message", message.toString());
			
			return true;
		}

		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) 
			throws Exception {


	}

	
}
