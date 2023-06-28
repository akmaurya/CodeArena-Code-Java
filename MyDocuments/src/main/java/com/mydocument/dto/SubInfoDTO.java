package com.mydocument.dto;



public class SubInfoDTO {
	private String subInfoName;
	private String subInfoData;
	
	public SubInfoDTO() {
	}

	public SubInfoDTO(String subInfoName, String subInfoData) {
		super();
		this.subInfoName = subInfoName;
		this.subInfoData = subInfoData;
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

	@Override
	public String toString() {
		return "SubInfoDTO [subInfoName=" + subInfoName + ", subInfoData=" + subInfoData + "]";
	}
	
	
	
}
