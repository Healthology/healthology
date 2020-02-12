package com.example.healthology.controllers;

import com.example.healthology.models.User;
import com.example.healthology.repositories.UsersRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	private UsersRepository userDao;

	public HelloController(UsersRepository userDao) {
		this.userDao = userDao;
	}

	@GetMapping("/hello")
	public String hello(Model model){
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("user", user);
			User user2 = userDao.getOne(2L);
			model.addAttribute("user2", user2);
			User user3 = userDao.getOne(3L);
			model.addAttribute("user3", user3);
			User user4 = userDao.getOne(4L);
			model.addAttribute("user4", user4);
			return "HelloWorld";
		} else {
			return "users/login";
		}
	}

}
