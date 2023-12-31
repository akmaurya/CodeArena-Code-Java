package com.src.java.cloning.deep;

public class DeepClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		Department hr = new Department(1, "Human Resource");
        Employee original = new Employee(1, "Admin", hr);
        Employee cloned = (Employee) original.clone();
 
        //Let change the department name in cloned object and we will verify in original object
        cloned.setEmpoyeeId(34);
		cloned.setEmployeeName("GPSEmployee");
        cloned.getDepartment().setName("Finance");
 
        System.out.println("Original Department Name: " + original.getEmpoyeeId() + "---" + original.getEmployeeName()
				+ "-----" + original.getDepartment().getName());
        System.out.println("Modified Department Name: " + cloned.getEmpoyeeId() + "---" + cloned.getEmployeeName()
				+ "-----" +cloned.getDepartment().getName());
	}
}
