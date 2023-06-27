package com.gps.spring.aop.service;

import com.gps.spring.aop.pojo.Customer;

public class CustomerService {
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
