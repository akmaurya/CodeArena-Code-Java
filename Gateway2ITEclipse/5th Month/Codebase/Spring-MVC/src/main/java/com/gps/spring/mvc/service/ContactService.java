package com.gps.spring.mvc.service;

import java.util.List;

import com.gps.spring.mvc.model.Contact;

public interface ContactService {
	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}
