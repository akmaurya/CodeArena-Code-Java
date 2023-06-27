package com.src.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {
	public static void main(String[] args) throws ClassNotFoundException {
		Connection con = null;
		ResultSet rs = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(DatabaseConfiguration.URL.getStrVal(),
					DatabaseConfiguration.USERNAME.getStrVal(), DatabaseConfiguration.PASSWORD.getStrVal());

			String sql = "select * from Employee";

			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("EmpID") + "  " + rs.getString("EmpName") + "  "
						+ rs.getFloat("EmpSalary") + "  " + rs.getInt("EmpAge"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
