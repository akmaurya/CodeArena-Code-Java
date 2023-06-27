package com.gps.spring.ioc.pojo;

/**
 * 
 * @author GPS
 *
 */
public class Address {
	private String flatNo;
	private String area;
	private String city;
	private String country;

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address is [" + flatNo + ", " + area + ", " + city + ", "
				+ country + "]";
	}
}
