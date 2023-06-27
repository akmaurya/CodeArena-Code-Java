package com.gps.spring.ioc.pojo;

import java.util.List;

/**
 * 
 * @author GPS
 *
 */
public class Customer {
	private int type;
	private String action;
	private String country;
	private List<String> preferredLocation;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}	
	
	public List<String> getPreferredLocation() {
		return preferredLocation;
	}

	public void setPreferredLocation(List<String> preferredLocation) {
		this.preferredLocation = preferredLocation;
	}

	@Override
	public String toString() {
		String prefLoc = "PreferredLocation [";
		for(String loc: getPreferredLocation()) {
			prefLoc += " " + loc;
		}
		prefLoc += "]";
		return "Type [" + type + "], Action [" + action + "], Country [" + country + "] " + prefLoc;
	}
}
