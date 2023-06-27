package com.gps.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gps.spring.mvc.dao.ContactDao;
import com.gps.spring.mvc.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDao;

	@Transactional
	@Override
	public void addContact(Contact contact) {
		contactDao.addContact(contact);
	}

	@Transactional
	@Override
	public List<Contact> listContact() {
		return contactDao.listContact();
	}

	@Transactional
	@Override
	public void removeContact(Integer id) {
		contactDao.removeContact(id);
	}
}
