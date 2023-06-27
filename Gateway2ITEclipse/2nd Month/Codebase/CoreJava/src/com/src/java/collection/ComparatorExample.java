package com.src.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorExample {
	public static void main(String[] args) {
		EmployeeVO emp1 = new EmployeeVO();
		emp1.setEmpId("A001");
		emp1.setName("AAAA");
		emp1.setAge(30);

		EmployeeVO emp2 = new EmployeeVO();
		emp2.setEmpId("A004");
		emp2.setName("ZZZZ");
		emp2.setAge(20);

		EmployeeVO emp3 = new EmployeeVO();
		emp3.setEmpId("A002");
		emp3.setName("MMMM");
		emp3.setAge(50);

		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);

		System.out.println("List before Sorting: ");
		for (int i = 0; i < empList.size(); i++) {
			EmployeeVO emp = empList.get(i);
			System.out.println(emp.getEmpId() + "   " + emp.getName() + "   " + emp.getAge());
		}

		Collections.sort(empList, new EmployeeVOComparator());

		System.out.println("List after Sorting: ");
		for (int i = 0; i < empList.size(); i++) {
			EmployeeVO emp = empList.get(i);
			System.out.println(emp.getEmpId() + "   " + emp.getName() + "   " + emp.getAge());
		}
	}

}
