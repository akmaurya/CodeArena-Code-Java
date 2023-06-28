package com.mydocument.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Info {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String infoName;
    private String infoData;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "info_id")
    private List<SubInfo> subInfo;
	
	public Info() {
	}
	
	
	public Info(Long id, String infoName, String infoData, List<SubInfo> subInfo) {
		super();
		this.id = id;
		this.infoName = infoName;
		this.infoData = infoData;
		this.subInfo = subInfo;
	}







	@Override
	public String toString() {
		return "Info [id=" + id + ", infoName=" + infoName + ", infoData=" + infoData + ", subInfo=" + subInfo + "]";
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public List<SubInfo> getSubInfo() {
		return subInfo;
	}


	public void setSubInfo(List<SubInfo> subInfo) {
		this.subInfo = subInfo;
	}

	
}
