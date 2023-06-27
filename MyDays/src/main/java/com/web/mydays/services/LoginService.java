package com.web.mydays.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.mydays.dao.LoginDAO;
import com.web.mydays.model.UserLogin;


public class LoginService {
	@Autowired
	LoginDAO loginDAO;
	public boolean validateLogin(UserLogin userLogin) {
		userLogin = loginDAO.getUserLogin(userLogin);
		
		if(userLogin!=null)
		return true;
		return false;
	}
}
