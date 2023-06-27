package controllers.address;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.address.PersonBean;
import beans.employee.Employee;

@Controller
@RequestMapping("/addressPortal")
public class AddressController {
	
	@RequestMapping(value = "/addressForm", method = RequestMethod.GET)
	public String addressForm(Model model) {
		model.addAttribute("personBean", new PersonBean());
		return "addressForm";
	}
	
	/*@RequestMapping(value = "/addressForm")
	public String addressForm(Model model) {
		model.addAttribute(new Employee());
		return "addressForm";
	}*/
	
	/*@RequestMapping("/empform")    
    public String showform(Model m){    
        m.addAttribute("command", new Employee());  
        return "empform";   
    }  */
	
	/*@RequestMapping(value = "/editAddressForm", method = RequestMethod.GET)
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
	}*/

	
	

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