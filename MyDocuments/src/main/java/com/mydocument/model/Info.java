package com.mydocument.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Info {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String infoName;
    private String infoData;
	
	public Info() {
	}
	
	public Info(String infoName, String infoData) { 
		super();
		this.infoName = infoName;
		this.infoData = infoData;
	}
	
	@Override
	public String toString() {
		return "Info [infoName=" + infoName + ", infoData=" + infoData + "]";
	}
	public String getInfoName() {
		return infoName;
	}
	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}
	public String getInfoData() {
		return infoData;
	}
	public void setInfoData(String infoData) {
		this.infoData = infoData;
	}
	
	
}
