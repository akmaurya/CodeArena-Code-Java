package com.src.java.jdbc;

public enum DatabaseConfiguration {
	URL("jdbc:mysql://localhost:3306/gpsdb"),
	USERNAME("root"),
	PASSWORD("root");
	
	private String strVal;
	
	DatabaseConfiguration(final String str) {
		this.strVal = str;
	}
	
	public String getStrVal() {
		return strVal;
	}
}
