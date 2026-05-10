package com.fabrizio.spring.course.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fabrizio.spring.course.error.model.domain.User;

@Configuration
public class AppConfig {

	@Bean
	List<User> userData(){
		List<User> AListUser = new ArrayList<>();
		AListUser.add(new User(1L, "Fabrizio", "Risco"));
		AListUser.add(new User(2L, "Dexter", "Morgan"));
		AListUser.add(new User(3L, "David", "Bowiw"));
		AListUser.add(new User(4L, "Trent", "Reznor"));
		AListUser.add(new User(5L, "Selena", "Gomez"));
		return AListUser;
	}
}
