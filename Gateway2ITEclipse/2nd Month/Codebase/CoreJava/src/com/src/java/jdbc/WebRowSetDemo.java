package com.src.java.jdbc;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.WebRowSet;

import com.sun.rowset.WebRowSetImpl;

public class WebRowSetDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Connection conn = getConnection();
		Statement st = conn.createStatement();
		st.executeUpdate("create table survey (id int,name varchar(20));");
		st.executeUpdate("insert into survey (id,name ) values (1,'nameValue')");
		st.executeUpdate("insert into survey (id,name ) values (2,'anotherValue')");

		WebRowSet webRS;
		Statement stmt = null;
		stmt = conn.createStatement();
		webRS = null;
		String sqlQuery = "SELECT * FROM survey WHERE id='1'";
		ResultSet rs = 
				  stmt.executeQuery(sqlQuery);
		
		webRS = new WebRowSetImpl();
		webRS.populate(rs);
		rs.close();

		FileWriter fw = null;
		final File file = new File(System.getProperty("user.dir") + "\\src\\com\\src\\java\\resource\\TestSurvey.xml");
		fw = new FileWriter(file);
		System.out.println("Writing db data to file " + file.getAbsolutePath());
		webRS.writeXml(fw);

		// convert xml to a String object
		StringWriter sw = new StringWriter();
		webRS.writeXml(sw);
		System.out.println("==============");
		System.out.println(sw.toString());
		System.out.println("==============");
		fw.flush();
		fw.close();
		stmt.close();
		conn.close();
	}

	private static Connection getConnection() throws Exception {
		String url = DatabaseConfiguration.URL.getStrVal();
		return DriverManager.getConnection(url, DatabaseConfiguration.USERNAME.getStrVal(), DatabaseConfiguration.PASSWORD.getStrVal());
	}
}
