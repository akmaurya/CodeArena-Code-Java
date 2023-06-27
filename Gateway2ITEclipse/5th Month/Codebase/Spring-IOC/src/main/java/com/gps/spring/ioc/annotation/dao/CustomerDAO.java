package com.gps.spring.ioc.annotation.dao;

import org.springframework.stereotype.Component;

/**
 * '@Component' to indicate this is an auto scan component
 * 
 * @author GPS
 *
 */
@Component
public class CustomerDAO {
	@Override
	public String toString() {
		return "Hello , This is CustomerDAO";
	}
}
