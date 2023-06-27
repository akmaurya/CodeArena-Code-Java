package com.web.mydays.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.mydays.model.User;
import com.web.mydays.repository.UsersRepository;

@Controller
public class MainController {
	@Autowired
	UsersRepository usersRepository;

	@RequestMapping(value = "/")
	public String showWelcomePage() {
		return "welcome";
	}
	@RequestMapping(value = "/login")
	public String showLoginPage(Model m) {
		m.addAttribute("command", new User());
		return "login";
	}
	@RequestMapping(value = "/loginValidation")
	public String loginValidation(Model m,@ModelAttribute("emp") User user) {
			m.addAttribute("user", user);
		return "user";
	}
}