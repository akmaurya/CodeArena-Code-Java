package model;

public class User {
	private String name;
	private String contactNo;
	private String email;
	private String password;
	private String isDeleted;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String isDeleted() {
		return isDeleted;
	}
	public void setDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
}
