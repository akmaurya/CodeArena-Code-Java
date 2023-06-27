package com.gps.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gps.spring.mvc.model.Contact;
import com.gps.spring.mvc.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;

	@RequestMapping("/contact")
	public ModelAndView listContacts() {
		ModelAndView model = new ModelAndView("contact");
		model.addObject("contactList", contactService.listContact());
		return model;
	}
	
	/**
	 * @ModelAttribute Annotation at method level - Add common object to Model
	 *                 when any of the controller method get called
	 * 
	 * @param model
	 */
	@ModelAttribute
	public void addCommonObject(Model model) {
		model.addAttribute("contact", new Contact());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {
		contactService.addContact(contact);		
		return "redirect:/contact";
	}

	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {
		contactService.removeContact(contactId);
		return "redirect:/contact";
	}
}
