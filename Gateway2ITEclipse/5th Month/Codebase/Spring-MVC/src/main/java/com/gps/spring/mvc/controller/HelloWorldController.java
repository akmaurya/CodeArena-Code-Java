package com.gps.spring.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")
public class HelloWorldController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView("helloPage");
		model.addObject("msg", "Hello World Application");
		return model;
	}

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public ModelAndView hi() {
		ModelAndView model = new ModelAndView("helloPage");
		model.addObject("msg", "Hi How are you...");
		return model;
	}

	@RequestMapping(value = "/welcome/{userName}/{password}")
	public ModelAndView getUriTemplateVariable(@PathVariable("userName") String name,
			@PathVariable("password") String password) {
		ModelAndView model = new ModelAndView("helloPage");
		model.addObject("msg", "Hi How are you...[" + name + "], Password [" + password + "]");
		return model;
	}
	
	@RequestMapping(value = "/welcome/{userName}/{password}/{org}")
	public ModelAndView getAllUriTemplateVariable(@PathVariable Map<String, String> pathVars) {
		ModelAndView model = new ModelAndView("helloPage");
		String param = "Username [" + pathVars.get("userName") + "]\n";
		param += "Password [" + pathVars.get("password") + "]\n";
		param += "Organization [" + pathVars.get("org") + "]";
		
		model.addObject("msg", "Hi How are you..." + param);
		return model;
	}
}
