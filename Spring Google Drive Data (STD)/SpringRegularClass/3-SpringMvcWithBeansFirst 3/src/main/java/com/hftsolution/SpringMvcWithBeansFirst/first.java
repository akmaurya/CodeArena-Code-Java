package com.hftsolution.SpringMvcWithBeansFirst;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class first {
	

	public void func(){		
		System.out.println("first running");
	}
	
	
	public void starting() {
		System.out.println("starting is running.");
	}
	
	
	public void ending() {
		System.out.println("ending is running.");
	}



private JdbcTemplate con;

public JdbcTemplate getCon() {
	return con;
}

public void setCon(JdbcTemplate con) {
	this.con = con;
}

public void getData() {
	try {
	List<?> abc = con.queryForList("select * from administration");
	System.out.println(abc.size());
	System.out.println(abc.toString());
	}catch(Exception e){
		e.printStackTrace();
	}
	}










}
