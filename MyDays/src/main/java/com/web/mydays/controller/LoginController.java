package com.web.mydays.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mydays.model.User;
import com.web.mydays.model.UserLogin;
import com.web.mydays.services.UserService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("login", new UserLogin());
		return "login/loginPage";
	}
	@RequestMapping(value="/loginValidate", method = RequestMethod.POST)
	public ModelAndView loginValidate(@ModelAttribute("login")UserLogin userLogin){
		ModelAndView model;
		UserService userService = new UserService();
		User user = userService.getUser(userLogin);
		
		if(user!=null) {
			model = new ModelAndView("login/userPage");
			model.addObject("user", user);
		}else {
			model = new ModelAndView("login/loginPage");
			model.addObject("ERROR", "Invalid combination of User ID and Password.");
		}
		return model;
	}
}

