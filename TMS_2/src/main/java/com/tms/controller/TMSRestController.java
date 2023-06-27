package com.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tms.model.Employee;
import com.tms.service.EmployeeService;

@RestController
public class TMSRestController {
	
	@Autowired
	private EmployeeService userService;
	
	@RequestMapping(value = "save-user", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView saveUser(@ModelAttribute("user") Employee user, BindingResult result, Model model) {
		userService.saveEmployee(user);
		ModelAndView loginView = new ModelAndView("login");
	    return loginView;
    }
	
	@RequestMapping(path="/validate-user", produces=MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    ModelAndView getUser(@RequestParam(name="email") String email, @RequestParam(name="password") String password) {
		boolean isValid = false;
		//isValid = userService.isUserExists(email,password);
		ModelAndView view = null;
		if(true) {
			view = new ModelAndView("home");
		} else {
			view = new ModelAndView("errorpage");
		}
		return view;
	}
	
	
	

}
