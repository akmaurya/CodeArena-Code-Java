package com.src.java.io.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestExternalEmployee {
	public static void main(String[] args) {
		GpsExternalEmployee emp1 = new GpsExternalEmployee();
		emp1.setId("1");
		emp1.setName("Suresh");
		emp1.setFlatNo("AAA");
		emp1.setAge(20);
		emp1.setCity("Chennai");

		GpsExternalEmployee emp2 = new GpsExternalEmployee();
		emp2.setId("2");
		emp2.setName("Rahman");
		emp2.setFlatNo("BBB");
		emp2.setAge(20);
		emp2.setCity("Patna");
		File file = new File("ExternalEmployeeDetail.txt");

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
			GpsExternalEmployee emp3 = (GpsExternalEmployee) in.readObject();
			GpsExternalEmployee emp4 = (GpsExternalEmployee) in.readObject();
			in.close();
			System.out.println(emp3.getId() + "  " + emp3.getName() + "  " + emp3.getFlatNo() + "  " + emp3.getAge() + "  " + emp3.getCity());
			System.out.println(emp4.getId() + "  " + emp4.getName() + "  " + emp4.getFlatNo() + "  " + emp4.getAge() + "  " + emp4.getCity());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
