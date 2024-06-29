package com.gontuseries.hellocontroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{

	static {
		System.out.println("Working static block");
	}
	@RequestMapping("/welcome")
	public ModelAndView helloWorld(){
		
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "Hellow World");
		
		return model;
	}

}
