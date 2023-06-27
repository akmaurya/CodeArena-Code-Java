package com.src.java.java6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExceptionHandling {
	public static void main(String[] args) throws ClassNotFoundException {
		Connection con = null;
		ResultSet rs = null;
		try {
			// Class.forName("org.hsqldb.jdbc.JDBCDriver");

			con = DriverManager.getConnection("jdbc:hsqldb:D:\\AmitKumar\\Personal\\PPT\\Database", "sa", "sa");

			String sql = "select * from TESTNotExist";

			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("EmpID") + "  " + rs.getString("EmpName") + "  "
						+ rs.getFloat("EmpSalary") + "  " + rs.getInt("EmpAge"));
			}
		} catch (SQLException sx) {
			for (Throwable e : sx) {
				System.err.println("Error encountered: " + e);
			}
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
