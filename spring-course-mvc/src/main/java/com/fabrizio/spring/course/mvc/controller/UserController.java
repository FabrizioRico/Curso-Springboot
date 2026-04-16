package com.fabrizio.spring.course.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fabrizio.spring.course.mvc.model.User;

@Controller
public class UserController {

	@GetMapping("/details")
	public String details(Model model) {
		model.addAttribute("title", "Pasando datos desde el controlador");
		model.addAttribute("name", "Fabrizio Omar");
		model.addAttribute("lastname", "Risco Alva");
		model.addAttribute("email", "fabrizioriscoalva05@gmail.com");
		
		User user = new User("Omar Fabrizio", "Risco Alva", "omaralvarisco50@gmail.com");
		user.setEmail("fabrizioriscoalva05@gmail.com");
		model.addAttribute("user", user);
		return "details";
	}
	
	@GetMapping("/list")
	public String list(ModelMap model){
		List<User> listUser = new ArrayList<>(); 
		model.addAttribute("listUser", listUser);
		model.addAttribute("title", "List of Users");
		
		User user1 = new User("David","Bowie","david.bowie67@gmail.com");
		User user2 = new User("David","Lynch");
		User user3 = new User("Mike","Patton","mike.patton69@hotmail.com");
		
		listUser.add(user1);
		listUser.add(user2);
		listUser.add(user3);
		
		return "list";
	}
	
//	@GetMapping("/list")
//	public String list(ModelMap model){
//		List<User> listUser = Arrays.asList(
//				new User("David","Bowie","david.bowie67@gmail.com"),
//				new User("David","Lynch"),
//				new User("Mike","Patton","mike.patton69@hotmail.com"));
//		
//		model.addAttribute("listUser", listUser);
//		model.addAttribute("title", "List of Users");
//		
//		return "list";
//	}
	 
	@ModelAttribute("listUser")
	public List<User> userModel(){
		List<User> listUser = Arrays.asList(
				new User("David","Bowie","david.bowie67@gmail.com"),
				new User("David","Lynch"),
				new User("Mike","Patton","mike.patton69@hotmail.com"));
		
		return listUser;
	}
	
//	@ModelAttribute("listUser")
//	public List<User> userModel(){
//		List<User> listUser = new ArrayList<>();
//		
//		User user1 = new User("David","Bowie","david.bowie67@gmail.com");
//		User user2 =	new User("David","Lynch");
//		User user3 = new User("Mike","Patton","mike.patton69@hotmail.com");
//		
//		listUser.add(user1);
//		listUser.add(user2);
//		listUser.add(user3);
//		
//		return listUser;
//	}
}
