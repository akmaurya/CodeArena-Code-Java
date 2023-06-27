package com.src.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class InsertData {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		try {

			MysqlDataSource  ds = new MysqlDataSource();
			ds.setURL(DatabaseConfiguration.URL.getStrVal());
			ds.setUser(DatabaseConfiguration.USERNAME.getStrVal());
			ds.setPassword(DatabaseConfiguration.PASSWORD.getStrVal());
			con = ds.getConnection();
			// Transaction started
			con.setAutoCommit(false);

			String sql = "insert into Employee values(?,?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "GPS0011");
			pstmt.setString(2, "Amit11");
			pstmt.setFloat(3, 34.6f);
			pstmt.setInt(4, 21);

			int res = pstmt.executeUpdate();
			System.out.println(res + " record inserted successfully");
			con.commit();
			// Transaction ended 

			sql = "select * from Employee";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			System.out.println("\nRecord are:");
			while (rs.next()) {
				System.out.println(rs.getString("EmpID") + "  " + rs.getString("EmpName") + "  "
						+ rs.getFloat("EmpSalary") + "  " + rs.getInt("EmpAge"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
