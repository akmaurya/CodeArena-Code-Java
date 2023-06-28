package com.mydocument.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubInfo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subInfoName;
    private String subInfoData;
    
    public SubInfo() {
	}
    
	public SubInfo(Long id, String subInfoName, String subInfoData) {
		super();
		this.id = id;
		this.subInfoName = subInfoName;
		this.subInfoData = subInfoData;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubInfoName() {
		return subInfoName;
	}
	public void setSubInfoName(String subInfoName) {
		this.subInfoName = subInfoName;
	}
	public String getSubInfoData() {
		return subInfoData;
	}
	public void setSubInfoData(String subInfoData) {
		this.subInfoData = subInfoData;
	}
    
    
}
