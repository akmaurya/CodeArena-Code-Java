package com.src.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ReadDataByPSusingDataSource {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		try {
			// We can use BasicDataSource provided by drivers
			MysqlDataSource  ds = new MysqlDataSource();
			ds.setURL(DatabaseConfiguration.URL.getStrVal());
			ds.setUser(DatabaseConfiguration.USERNAME.getStrVal());
			ds.setPassword(DatabaseConfiguration.PASSWORD.getStrVal());
			con = ds.getConnection();

			String sql = "select * from Employee where EmpAge >= ?";

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
