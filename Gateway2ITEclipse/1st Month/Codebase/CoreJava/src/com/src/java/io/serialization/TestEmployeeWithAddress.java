package com.src.java.io.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestEmployeeWithAddress {
	public static void main(String[] args) {
		GpsEmployee emp1 = new GpsEmployee("1", "Suresh");
		emp1.setFlatNo("AAA");
		emp1.setAge(20);
		emp1.setCity("Chennai");

		GpsEmployee emp2 = new GpsEmployee("2", "rahman");
		emp2.setFlatNo("BBB");
		emp2.setAge(20);
		emp2.setCity("Patna");

		File file = new File("EmployeeDetail.txt");
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

			out.writeObject(emp1);
			out.writeObject(emp2);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

			GpsEmployee emp3 = (GpsEmployee) in.readObject();
			GpsEmployee emp4 = (GpsEmployee) in.readObject();
			in.close();
			System.out.println(emp3.getId() + "  " + emp3.getName() + "  " + emp3.getFlatNo() + "  " + emp3.getAge() + "  " + emp3.getCity());
			System.out.println(emp4.getId() + "  " + emp4.getName() + "  " + emp4.getFlatNo() + "  " + emp4.getAge() + "  " + emp4.getCity());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
