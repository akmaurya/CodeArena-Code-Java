package com.mydocument.dto;

import java.sql.Date;
import java.util.List;


public class PersonDTO {
	private String name;
    private Date dob;
    private String gender;
    private String contactNo;
    private List<DocumentDTO> documents;

    // Default constructor
    public PersonDTO() {
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public List<DocumentDTO> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentDTO> documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		return "PersonDTO [name=" + name + ", dob=" + dob + ", gender=" + gender + ", contactNo=" + contactNo
				+ ", documents=" + documents + "]";
	}

}
