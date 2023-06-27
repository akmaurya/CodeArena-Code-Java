package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ViewController {
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String backToHome(ModelMap model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/addressForm", method = RequestMethod.GET)
	public String addressForm(ModelMap model) {
		
		return "addressForm";
	}
	
	@RequestMapping(value = "/editAddressForm", method = RequestMethod.GET)
	public String editAddressForm(ModelMap model) {
		
		return "editAddressForm";
	}
	
	@RequestMapping(value = "/showAddress", method = RequestMethod.GET)
	public String showAddress(ModelMap model) {
		
		return "showAddress";
	}
	
	@RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
	public String deleteAddress(ModelMap model) {
		
		return "deleteAddress";
	}
	
	@RequestMapping(value = "/employeePortal", method = RequestMethod.GET)
	public String employeePortal(ModelMap model) {
		
		return "employee/employeeHome";
	}
	
	@RequestMapping(value = "/addressPortal", method = RequestMethod.GET)
	public String addressPortal(ModelMap model) {
		
		return "addressHome";
	}
	
	
	

/*	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "home";
	}

	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model, HttpServletRequest request) {
		model.addAttribute("greeting", "Hello "+request.getParameter("name")+" in Spring 4 MVC");
		return "home";
	}*/
}