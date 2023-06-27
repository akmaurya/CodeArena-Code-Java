package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddUser {
	@RequestMapping("adduser")
	public String addUser(Model model){
		model.addAttribute("userForm", new UserForm());
		return "adduser";
	}

}
