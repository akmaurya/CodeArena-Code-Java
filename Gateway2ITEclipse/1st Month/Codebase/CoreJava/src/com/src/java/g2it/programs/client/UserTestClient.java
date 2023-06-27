package com.src.java.g2it.programs.client;

import com.src.java.g2it.programs.User;

public class UserTestClient {
	public static void main(String[] args) {
		User usr[] = new User[5];
		
		usr[0] = new User();
		usr[0].setId(1);
		usr[0].setName("Amit");
		
		System.out.println(usr[0].getId() + "---" + usr[0].getName());
	}
}
