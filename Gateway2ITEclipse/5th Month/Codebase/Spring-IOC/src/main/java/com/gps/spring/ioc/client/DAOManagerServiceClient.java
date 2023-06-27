package com.gps.spring.ioc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.ioc.dao.DAOManagerFactory;
import com.gps.spring.ioc.pojo.Connection;

public class DAOManagerServiceClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AutoWiredConfig.xml");

		Connection connection = ((DAOManagerFactory) context.getBean("daoManagerFactory")).getConnection();
		System.out.println(connection);
	}
}
