package com.gps.spring.ioc.dao;

import com.gps.spring.ioc.pojo.Connection;

/**
 * 
 * @author GPS
 *
 */
public class DAOManagerFactory {

	private Connection connection = null;

	public DAOManagerFactory() {}
	
	public DAOManagerFactory(Connection connection, Connection connection1) {
		this.connection = connection;
		this.connection = connection1;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}	
}
