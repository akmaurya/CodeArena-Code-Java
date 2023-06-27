package com.gps.spring.mvc.model;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * User Registration Model
 * 
 * @author GPS
 *
 */
public class User {
	@Pattern(regexp = "\\D*", message = "Invalid username. Number not allowed.")
	private String userName;

	 @Size(min = 5, max = 10, message =
	 "Length of email Id should be >={min} & <={max}")
	//@Size(min = 5, max = 10)
	@Email(message = "Invalid Email Id")
	private String emailId;

	private String password;
	private Long phone;

	@Past(message = "DOB can't be greater than today's date")
	private Date dob;

	private List<String> preferredLocation;

	@Valid
	private Address userAddress;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<String> getPreferredLocation() {
		return preferredLocation;
	}

	public void setPreferredLocation(List<String> preferredLocation) {
		this.preferredLocation = preferredLocation;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
}
