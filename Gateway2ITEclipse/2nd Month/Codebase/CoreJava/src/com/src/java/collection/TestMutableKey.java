package com.src.java.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMutableKey {
	public static void main(String[] args) {
		// Create a HashMap with mutable key
		Map<Account, String> map = new HashMap<Account, String>();

		// Create key 1
		Account a1 = new Account(1);
		a1.setHolderName("A_ONE");
		// Create key 2
		Account a2 = new Account(2);
		a2.setHolderName("A_TWO");

		// Put mutable key and value in map
		map.put(a1, a1.getHolderName());
		map.put(a2, a2.getHolderName());

		// Success !! We are able to get back the values
		System.out.println(map.get(a1)); // Prints A_ONE
		System.out.println(map.get(a2)); // Prints A_TWO

		// Change the keys state so hash map should be calculated again
		a1.setHolderName("Defaulter");
		a2.setHolderName("Bankrupt");

		// Success !! We are able to get back the values
		System.out.println(map.get(a1)); // Prints A_ONE
		System.out.println(map.get(a2)); // Prints A_TWO

		// Try with newly created key with same account number
		Account a3 = new Account(1);
		a3.setHolderName("A_THREE");

		// Success !! We are still able to get back the value for account number
		// 1
		System.out.println("A3:" + map.get(a3)); // Prints A_ONE
		

		// Try with newly created key with same account number
		Account a4 = new Account(4);
		a4.setHolderName("A_FOUR");
		map.put(a4, a4.getHolderName());
		
		System.out.println(a1.equals(a3));
		
		// Failure !! We are not able to get back the value for account number
		// 4
		System.out.println(map.get(a4)); // Prints A_FOUR
	}
}
