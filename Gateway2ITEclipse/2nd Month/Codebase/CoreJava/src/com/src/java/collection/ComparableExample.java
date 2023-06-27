package com.src.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
	public static void main(String[] args) {
		GPSEmployee emp1 = new GPSEmployee();
		emp1.setEmpId("A001");
		emp1.setName("AAAA");
		emp1.setAge(30);

		GPSEmployee emp2 = new GPSEmployee();
		emp2.setEmpId("A004");
		emp2.setName("ZZZZ");
		emp2.setAge(20);

		GPSEmployee emp3 = new GPSEmployee();
		emp3.setEmpId("A002");
		emp3.setName("MMMM");
		emp3.setAge(50);

		List<GPSEmployee> empList = new ArrayList<GPSEmployee>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);

		System.out.println("List before Sorting: ");
		for (int i = 0; i < empList.size(); i++) {
			GPSEmployee emp = empList.get(i);
			System.out.println(emp.getEmpId() + "   " + emp.getName() + "   " + emp.getAge());
		}

		Collections.sort(empList);

		System.out.println("List after Sorting: ");
		for (int i = 0; i < empList.size(); i++) {
			GPSEmployee emp = empList.get(i);
			System.out.println(emp.getEmpId() + "   " + emp.getName() + "   " + emp.getAge());
		}
	}
}
