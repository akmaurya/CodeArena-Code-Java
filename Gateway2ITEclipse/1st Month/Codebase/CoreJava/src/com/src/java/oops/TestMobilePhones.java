package com.src.java.oops;

public class TestMobilePhones {
	public static void main(String[] args) {
		Nokia1400 nokia1400 = new Nokia1400();
		nokia1400.Calling();
		nokia1400.SendSMS();
		
		Nokia2700 nokia2700 = new Nokia2700();
		nokia2700.Calling();
		nokia2700.SendSMS();
		nokia2700.FMRadio();
		nokia2700.MP3();
		nokia2700.Camera();
		
		BlackBerry blackBerry = new BlackBerry();
		blackBerry.Calling();
		blackBerry.SendSMS();
		blackBerry.FMRadio();
		blackBerry.MP3();
		blackBerry.Camera();
		blackBerry.Recording();
		blackBerry.ReadAndSendEmails();
	}
}
