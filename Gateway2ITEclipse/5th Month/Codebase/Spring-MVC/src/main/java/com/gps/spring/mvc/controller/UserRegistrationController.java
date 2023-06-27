package com.gps.spring.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * New User Registration Controller
 * 
 * @author GPS
 *
 */
@Controller
public class UserRegistrationController {

	@RequestMapping(value = "/userRegisterationForm", method = RequestMethod.GET)
	public ModelAndView getUserRegistrationForm() {
		ModelAndView model = new ModelAndView("userRegisterationForm");
		return model;
	}

//	@RequestMapping(value = "/submitUserRegistrationForm", method = RequestMethod.POST)
//	public ModelAndView submitUserRegisterationForm(
//			@RequestParam(value = "userName", defaultValue = "AmitGPS") String uName,
//			@RequestParam(value = "emailId") String email, @RequestParam("password") String pass) {
//		ModelAndView model = new ModelAndView("userRegisterationSuccess");
//
//		model.addObject("userName", uName);
//		model.addObject("msg", "Details are [" + email + " ----" + pass + "]");
//		return model;
//	}
	
	@RequestMapping(value = "/submitUserRegistrationForm", method = RequestMethod.POST)
	public ModelAndView submitUserRegisterationFormByMap(@RequestParam Map<String, String> params) {
		ModelAndView model = new ModelAndView("userRegisterationSuccess");

		model.addObject("userName", params.get("userName"));
		model.addObject("msg", "Details are [" + params.get("emailId") + " ----" + params.get("password") + "]");
		return model;
	}
}
