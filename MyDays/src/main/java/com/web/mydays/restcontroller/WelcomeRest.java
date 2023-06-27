package com.web.mydays.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.mydays.model.User;

@RestController
public class WelcomeRest {
	
	@RequestMapping("/welcomeRest")
	public User welcome() {
		User user = new User("Arvind", "101", 30, null);
		return user;
	}

}
