package com.src.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadDataByPS {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DatabaseConfiguration.URL.getStrVal(),
					DatabaseConfiguration.USERNAME.getStrVal(), DatabaseConfiguration.PASSWORD.getStrVal());

			String sql = "select * from Employee where EmpAge > ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 35);

			rs = pstmt.executeQuery();

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
