package com.c1India.loginVerification.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String name, String password) {

		if (name.equals(password))
			return true;

		return false;
	}

}
