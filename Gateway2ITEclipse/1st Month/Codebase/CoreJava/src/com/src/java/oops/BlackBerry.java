package com.src.java.oops;

public class BlackBerry extends MobilePhone {

	@Override
	public void Calling() {
		super.Calling();
		System.out.println("Advanced BlackBerry calling feature...");
	}

	@Override
	public void SendSMS() {
		super.SendSMS();
		System.out.println("Advanced BlackBerry SMS sending feature...");
	}

	public void FMRadio() {
		System.out.println("BlackBerry FMRadio feature...");
	}

	public void MP3() {
		System.out.println("BlackBerry MP3 feature...");
	}

	public void Camera() {
		System.out.println("BlackBerry Camera feature...");
	}

	public void Recording() {
		System.out.println("BlackBerry Recording feature...");
	}

	public void ReadAndSendEmails() {
		System.out.println("BlackBerry ReadAndSendEmails feature...");
	}
}
