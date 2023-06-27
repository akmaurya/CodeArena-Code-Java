package com.src.java.io.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class SerializeEmployee {
	public static void main(String[] args) {
		Employee emp = new Employee("E001", "GPS Infosolution");

		 // save the object to file
	    FileOutputStream fos = null;
	    ObjectOutputStream out = null;
	    try {
	      fos = new FileOutputStream("Employee.txt");
	      out = new ObjectOutputStream(fos);
	      out.writeObject(emp);

	      out.close();
	      System.out.println("Employee data serialized successfully...");
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	}
}
