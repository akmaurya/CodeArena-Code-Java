package com.mydocument.dto;



public class InfoDTO {
	private String infoName;
	private String infoData;
	
	public InfoDTO() {
	}
	
	public InfoDTO(String infoName, String infoData) { 
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
