package com.gps.spring.ioc.annotation.client;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceHandlingClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "annotation/AutoScanConfig.xml" });

		String name = context.getMessage("customer.name", new Object[] { 35, "http://www.gpsinfosolution.com" },
				"Default Message", Locale.US);

		System.out.println("Customer name (English) : " + name);

		String namechinese = context.getMessage("customer.name", new Object[] { 37, "http://www.google.com" },
				"Default Message123", Locale.SIMPLIFIED_CHINESE);

		System.out.println("Customer name (Chinese) : " + namechinese);

	}
}
