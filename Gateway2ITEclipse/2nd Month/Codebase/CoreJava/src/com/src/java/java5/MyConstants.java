package com.src.java.java5;

public enum MyConstants {
	TEMP1("TEMP1"), TEMP2("TEMP2"), TEMP3(10);

	private String strVal;
	private int iVal;
		
	MyConstants(String str) {
		this.strVal = str;
	}

	MyConstants(int i) {
		this.iVal = i;
	}

	public String getStrVal() {
		return strVal;
	}

	public int getiVal() {
		return iVal;
	}	

}
