package com.first.work;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/abc")
public class first {

	@Value("${key}")
	String value;
	
	@RequestMapping("/firstPage")
	public String normal(ModelMap map) {		
//		System.out.println(value);
		abc obj = new abc();
		map.addAttribute("pageObj",obj);
		
		return "first";
	}
	
	
	@RequestMapping("/submit")
	public void submitFun(@ModelAttribute("pageObj")abc abc,@RequestParam("first")String stringName) {		
		System.out.println(stringName);
		System.out.println(abc);
//		return "first";
	}
}
