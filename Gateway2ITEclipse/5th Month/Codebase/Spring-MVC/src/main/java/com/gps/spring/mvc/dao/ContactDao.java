package com.gps.spring.mvc.dao;

import java.util.List;

import com.gps.spring.mvc.model.Contact;

public interface ContactDao {
	void addContact(Contact contact);
	List<Contact> listContact();
	void removeContact(Integer id);
}
