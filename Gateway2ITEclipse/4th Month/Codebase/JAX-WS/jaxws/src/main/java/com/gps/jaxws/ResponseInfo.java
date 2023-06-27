package com.gps.jaxws;

/**
 * POJO to store webservice response
 * 
 * @author GPS
 *
 */
public class ResponseInfo {
	public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public double getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}

	public int getResponseCodeNumber() {
		return responseCodeNumber;
	}

	public void setResponseCodeNumber(int responseCodeNumber) {
		this.responseCodeNumber = responseCodeNumber;
		this.responseCode = "" + responseCodeNumber;
	}

	String responseString = "";
	String responseCode = "";
	long responseTime = 0;
	int responseCodeNumber = 0;
	double averageResponseTime = 0;
	double successResponsePerc = 0;

	public double getSuccessResponsePerc() {
		return successResponsePerc;
	}

	public void setSuccessResponsePerc(double successResponsePerc) {
		this.successResponsePerc = successResponsePerc;
	}

	public void reset() {
		setResponseString("");
		setResponseTime(-1);
		setResponseCode("0");
		setSuccessResponsePerc(0);
	}

	public void setAverageResponseTime(double averageResponseTime) {
		this.averageResponseTime = averageResponseTime;
	}

}
