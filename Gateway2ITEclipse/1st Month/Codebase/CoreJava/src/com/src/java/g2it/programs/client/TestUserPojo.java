package com.src.java.g2it.programs.client;

import com.src.java.g2it.programs.User;

public class TestUserPojo {
	public static void main(String[] args) {
		User user1 = new User();
		user1.setId(5);
		user1.setName("Mannu");
		user1.setPassword("jjjj");
		user1.setEmail("mannu@gmail.com");
		user1.setContactNumber("44343232");
		
		User user2 = new User();
		user2.setId(7);
		user2.setName("Akash");
		user2.setPassword("jjjjdewew");
		user2.setEmail("akash@gmail.com");
		user2.setContactNumber("4332232344545");
		
		System.out.println(user1.getId() + "----" + user1.getName());
		System.out.println(user2.getId() + "----" + user2.getName());
	}
}
