package com.gps.spring.aop.service;

import com.gps.spring.aop.pojo.Customer;
import com.gps.spring.aop.pojo.Employee;
import com.gps.spring.aop.pojo.proxies.RoleVOProxy;

/**
 * Factory class
 * 
 * @author GPS
 *
 */
public class FactoryService {
	public Object getBean(String beanType) {
		if (beanType.equals("customer")) {
			return new Customer();
		}
		if (beanType.equals("employee")) {
			return new Employee();
		}
		if (beanType.equals("rolevo")) {
			return new RoleVOProxy();
		}

		return null;
	}
}
