package com.gps.spring.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gps.spring.jdbc.model.Employee;

public class EmployeeDaoImplNoSpring {
	
	public List<Employee> getEmployeeList() {
		Connection con = null;
		ResultSet rs = null;
		List<Employee> empList = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gpsdb", "root", "root");

			String sql = "select * from Employee";

			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			if (rs != null) {
				empList = new ArrayList<Employee>();
			}
			Employee emp = null;
			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getString("EmpID"));
				emp.setEmpName(rs.getString("EmpName"));
				emp.setEmpAge(rs.getInt("EmpAge"));
				emp.setEmpSalary(rs.getFloat("EmpSalary"));
				empList.add(emp);
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
		return empList;
	}
}
