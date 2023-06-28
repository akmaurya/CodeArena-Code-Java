package com.mydocument.dto;

import java.util.List;

import com.mydocument.model.SubInfo;

public class InfoDTO {
	private String infoName;
	private String infoData;
	
	private List<SubInfo> subInfo;
	
	public InfoDTO() {
	}

	public InfoDTO(String infoName, String infoData, List<SubInfo> subInfo) {
		super();
		this.infoName = infoName;
		this.infoData = infoData;
		this.subInfo = subInfo;
	}
	
	

	@Override
	public String toString() {
		return "InfoDTO [infoName=" + infoName + ", infoData=" + infoData + ", subInfo=" + subInfo + "]";
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

	public List<SubInfo> getSubInfo() {
		return subInfo;
	}

	public void setSubInfo(List<SubInfo> subInfo) {
		this.subInfo = subInfo;
	}
	
		
}
