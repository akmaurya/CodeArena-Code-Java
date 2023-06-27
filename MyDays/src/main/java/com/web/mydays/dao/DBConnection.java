package com.web.mydays.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static DriverManager dm;
	public static Connection getConnection() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/mydays";
			String username = "root";
			String password = "root";
			
			return DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}


