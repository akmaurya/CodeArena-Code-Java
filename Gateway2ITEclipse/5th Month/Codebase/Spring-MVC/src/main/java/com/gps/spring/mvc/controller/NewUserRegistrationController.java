package com.gps.spring.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gps.spring.mvc.custom.UserNameEditor;
import com.gps.spring.mvc.model.User;

/**
 * New User Registration Controller
 * 
 * @author GPS
 *
 */
@Controller
public class NewUserRegistrationController {

	@RequestMapping(value = "/newUserRegisterationForm", method = RequestMethod.GET)
	public ModelAndView getUserRegistrationForm() {
		ModelAndView model = new ModelAndView("newUserRegisterationForm");
		return model;
	}

	/**
	 * Store new user registration form into a Model “User” without using @ModelAttribute
	 */
	// @RequestMapping(value = "/newUserSubmitRegistrationForm", method =
	// RequestMethod.POST)
	// public ModelAndView submitUserRegisterationFormByMap(@RequestParam
	// Map<String, String> params) {
	//
	// User user = new User();
	// user.setUserName(params.get("userName"));
	// user.setEmailId(params.get("emailId"));
	// user.setPassword(params.get("password"));
	//
	// ModelAndView model = new ModelAndView("newUserRegisterationSuccess");
	//
	// model.addObject("headerMsg",
	// "New User Successfully Registered at GPS Info...");
	// model.addObject("user", user);
	// return model;
	// }

	/**
	 * @ModelAttribute Annotation at method argument
	 */
	// @RequestMapping(value = "/newUserSubmitRegistrationForm", method =
	// RequestMethod.POST)
	// public ModelAndView
	// submitUserRegisterationFormByMap(@ModelAttribute("user") User user) {
	// System.out.println("Entry");
	// ModelAndView model = new ModelAndView("newUserRegisterationSuccess");
	// model.addObject("headerMsg",
	// "New User Successfully Registered at GPS Info...");
	// System.out.println("Exit");
	// return model;
	// }

	/**
	 * @ModelAttribute Annotation at method level - Add common object to Model
	 *                 when any of the controller method get called
	 * 
	 * @param model
	 *            //
	 */
	@ModelAttribute
	public void addCommonObject(Model model) {
		model.addAttribute("headerMsg", "New User Successfully Registered at GPS Info...");
	}

	/**
	 * Store new user registration form into a Model “User” using @ModelAttribute
	 * 
	 * If we provide string instead of number inside phone field OR any string
	 * instead of date format inside dob field using BindingResult
	 * 
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/newUserSubmitRegistrationForm", method = RequestMethod.POST)
	public ModelAndView submitUserRegisterationFormByMap(@Valid @ModelAttribute("user") User user, BindingResult result) {
		ModelAndView model = null;
		if (result.hasErrors()) {
			model = new ModelAndView("newUserRegisterationForm");
		} else {
			model = new ModelAndView("newUserRegisterationSuccess");
		}
		return model;
	}

	/*
	 * Let’s suppose we want to exclude phone field during data binding OR apply
	 * specific date format should be entered inside dob field.
	 */
	@InitBinder
	public void intialDataBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] { "phone" });

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

		binder.registerCustomEditor(String.class, "userName", new UserNameEditor());
	}
}
