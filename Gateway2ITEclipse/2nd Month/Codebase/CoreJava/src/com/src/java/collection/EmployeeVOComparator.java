package com.src.java.collection;

import java.util.Comparator;

public class EmployeeVOComparator implements Comparator<EmployeeVO> {
	@Override
	public int compare(EmployeeVO emp1, EmployeeVO emp2) {
		return emp1.getEmpId().compareTo(emp2.getEmpId());
	}
}