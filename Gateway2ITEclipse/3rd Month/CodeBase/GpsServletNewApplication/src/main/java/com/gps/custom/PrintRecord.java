package com.gps.custom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class PrintRecord extends TagSupport {
	private int age;
	private String table;

	public void setAge(final int age) {
		this.age = age;
	}

	public void setTable(final String table) {
		this.table = table;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gpsdb", "root", "root");

			String sql = "select * from " + table + " where EmpAge >= ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, age);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				ResultSetMetaData rsmd = rs.getMetaData();
				int totalcols = rsmd.getColumnCount();
				// column name
				out.write("<table border='1'>");
				out.write("<tr>");
				for (int i = 1; i <= totalcols; i++) {
					out.write("<th>" + rsmd.getColumnName(i) + "</th>");
				}
				out.write("</tr>");
				// column value

				while (rs.next()) {
					out.write("<tr>");
					for (int i = 1; i <= totalcols; i++) {
						out.write("<td>" + rs.getString(i) + "</td>");
					}
					out.write("</tr>");

				} 
				out.write("</table>");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return SKIP_BODY;
	}
}
