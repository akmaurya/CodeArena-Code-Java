package com.gontuseries.hellocontroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("greet")
public class HelloController2{

	@RequestMapping("/welcome/{userName}")
	public ModelAndView helloWorld(@PathVariable("userName") String name){
		
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "Hellow "+name);
		
		return model;
	}
	
	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView hi(@PathVariable("userName") String name, @PathVariable("countryName") String countryName)
	{
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "Hi "+name+" your are from "+countryName);
		return model;
	}

}
