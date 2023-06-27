package com.first;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingFirst {
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;

	@RequestMapping("/firstPage")
	public String requestMappingAll() {
		System.out.println("firstPage url is working");		
		return "firstPage";
	}
	
	
	@RequestMapping("/pathVariable/{id}/{name}")
	public String pathVariable(@PathVariable("id") String id,@PathVariable("name") String name) {
		System.out.println("firstPage url is working "+id);		
		return "firstPage";
	}
	
	
	@RequestMapping(value="/setFormData", method=RequestMethod.POST)
	public String functionName(HttpServletRequest req,ModelMap map) {		
		System.out.println("data is..");
//		System.out.println("name "+req.getParameter("name"));
//		System.out.println("id "+req.getParameter("id"));
		
		map.addAttribute("name",req.getParameter("name"));
		map.addAttribute("id",req.getParameter("id"));
		
		
		return "secondPage";
	}

}
