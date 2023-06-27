package com.gps.spring.mvc.custom;

import java.beans.PropertyEditorSupport;

/**
 * This is custom property editor class. When user will submit user registration
 * form SpringMVC will run setAsText function of this class, before performing
 * data binding task for User name property of User object.
 * 
 * @author GPS
 *
 */
public class UserNameEditor extends PropertyEditorSupport {

	public void setAsText(String userName) throws IllegalArgumentException {
		if (!(userName.contains("Mr.") || userName.contains("Ms."))) {
			userName = "Ms. " + userName;
		}
		setValue(userName);
	}
}
