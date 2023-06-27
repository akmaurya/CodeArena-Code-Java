package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.AddressBean;

@Controller
public class AddressController {
	{
		System.out.println("Working");
	}
	@RequestMapping(value = "/addAddress", method = RequestMethod.GET)
	public String addAddress(Model model){
		model.addAttribute("addressBean", new AddressBean());
		System.out.println("Hello.............");
		return "addAddressForm";
	}
	
	@RequestMapping(value = "/processAddAddress", method = RequestMethod.GET)
	public String processAddAddress(@ModelAttribute("addressBean") AddressBean addressBean){
		System.out.println(addressBean.getPinCode());
		return "addAddressForm";
	}
}
