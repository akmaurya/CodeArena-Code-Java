package com.src.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class UpdateData {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {

			MysqlDataSource ds = new MysqlDataSource();
			ds.setURL(DatabaseConfiguration.URL.getStrVal());
			ds.setUser(DatabaseConfiguration.USERNAME.getStrVal());
			ds.setPassword(DatabaseConfiguration.PASSWORD.getStrVal());
			con = ds.getConnection();

			String sql = "select * from Employee";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			System.out.println("\nBefore Update, Record are:");
			while (rs.next()) {
				System.out.println(rs.getString("EmpID") + "  " + rs.getString("EmpName") + "  "
						+ rs.getFloat("EmpSalary") + "  " + rs.getInt("EmpAge"));
			}

			con.setAutoCommit(false);

			sql = "update Employee set EmpName=?, EmpSalary=?, EmpAge=? where EmpId=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "ZZZZ1");
			pstmt.setFloat(2, 1223.453f);
			pstmt.setInt(3, 60);
			pstmt.setString(4, "GPS0011");

			int res = pstmt.executeUpdate();
			System.out.println("\n" + res + " record updated successfully");
			con.commit();

			sql = "select * from Employee";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			System.out.println("\nAfter Update, Record are:");
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
