package com.src.java.io.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeEmployee {
	public static void main(String[] args) {
		// read the object from file
		// save the object to file
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream("Employee.txt");
			in = new ObjectInputStream(fis);
			Employee emp = (Employee) in.readObject();
			if(emp != null) {
				System.out.println(emp.getId() + "----" + emp.getName());
			} else {
				System.out.println("Employee object is null...");
			}
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
