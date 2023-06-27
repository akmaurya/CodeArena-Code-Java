package com.src.java.jdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.JdbcRowSetImpl;

public class JdbcRowSetDemo {

	private JdbcRowSet rowSet = null;

	public JdbcRowSetDemo() {
		try {
			rowSet = new JdbcRowSetImpl();
			rowSet.setUrl(DatabaseConfiguration.URL.getStrVal());
			rowSet.setUsername(DatabaseConfiguration.USERNAME.getStrVal());
			rowSet.setPassword(DatabaseConfiguration.PASSWORD.getStrVal());
			rowSet.setCommand("SELECT * FROM employee");
			rowSet.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void showEmployees() {
		try {
			ResultSetMetaData metaData = rowSet.getMetaData();
			int noOfCols = metaData.getColumnCount();
			System.out.println("Employees");

			for (int i = 1; i <= noOfCols; i++) {
				System.out.printf("%-20s\t", metaData.getColumnName(i));
			}
			System.out.println();

			rowSet.first();
			while (rowSet.next()) {
				for (int i = 1; i <= noOfCols; i++) {
					System.out.printf("%-20s\t", rowSet.getObject(i));
				}
				System.out.println();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void addEmployee(String id, String name, float salary, int age) {
		try {
			rowSet.moveToInsertRow();
			rowSet.updateString("empId", id);
			rowSet.updateString("empName", name);
			rowSet.updateFloat("empSalary", salary);
			rowSet.updateInt("empAge", age);
			rowSet.insertRow();			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
        JdbcRowSetDemo d1=new JdbcRowSetDemo();
        d1.showEmployees();
        d1.addEmployee("E029", "Test123", 983.89f, 43);
        d1.showEmployees();
    }
}
