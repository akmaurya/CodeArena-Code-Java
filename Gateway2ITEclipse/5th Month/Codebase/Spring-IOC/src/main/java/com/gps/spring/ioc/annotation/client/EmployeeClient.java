package com.gps.spring.ioc.annotation.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.ioc.annotation.pojo.Employee;
import com.gps.spring.ioc.annotation.pojo.GPSEmployee;
import com.gps.spring.ioc.annotation.pojo.GPSResourceEmployee;

public class EmployeeClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("annotation/EmployeeConfig.xml");

		Employee employeeByIdAndNameWithAddress = (Employee) context.getBean("employeeByIdAndNameWithAddress");
		System.out.println(employeeByIdAndNameWithAddress);
		
		GPSEmployee gpsEmployeeByAddress = (GPSEmployee) context.getBean("gpsEmployeeByAddress");
		System.out.println(gpsEmployeeByAddress);
		
		GPSResourceEmployee gpsResourceEmployeeByAddress = (GPSResourceEmployee) context.getBean("gpsResourceEmployeeByAddress");
		System.out.println(gpsResourceEmployeeByAddress);
		
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
