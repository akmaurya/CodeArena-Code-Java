package com.web.mydays.services;

import com.web.mydays.dao.LoginDAO;
import com.web.mydays.dao.UserDAO;
import com.web.mydays.model.User;
import com.web.mydays.model.UserLogin;

public class UserService {
	
	public User getUser(UserLogin userLogin) {
		UserDAO userDAO = new UserDAO();
		if(validateUser(userLogin)) {
			return userDAO.getUser(userLogin);
		}
		
		return null;
	}
	
	public boolean validateUser(UserLogin userLogin) {
		LoginDAO loginDAO = new LoginDAO();
		userLogin = loginDAO.getUserLogin(userLogin);
		
		if(userLogin!=null)
		return true;
		return false;
	}
	
	
}

