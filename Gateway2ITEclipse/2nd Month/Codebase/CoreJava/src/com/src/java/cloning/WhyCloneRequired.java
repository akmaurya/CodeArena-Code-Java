package com.src.java.cloning;

public class WhyCloneRequired {
	public static void main(String[] args) throws CloneNotSupportedException {
		Department hr = new Department(1, "Human Resource");
		GPSEmployee original = new GPSEmployee(1, "Admin", hr);

		System.out.println("Before Method called - ");
		System.out.println(original.getEmpoyeeId() + "---" + original.getEmployeeName() + "---"
				+ original.getDepartment().getId() + "---" + original.getDepartment().getName());
		
		updateGPSEmployee(original);
		System.out.println("After Method called - ");
		System.out.println(original.getEmpoyeeId() + "---" + original.getEmployeeName() + "---"
				+ original.getDepartment().getId() + "---" + original.getDepartment().getName());	
		
		Department finanace = new Department(1, "Finance");
		Employee emp = new Employee(1, "Administrator", finanace);
		System.out.println("\n\nSolution: Before Method called - ");
		System.out.println(emp.getEmpoyeeId() + "---" + emp.getEmployeeName() + "---"
				+ emp.getDepartment().getId() + "---" + emp.getDepartment().getName());
		Employee cloneEmp = (Employee) emp.clone();
		updateEmployee(cloneEmp);
		System.out.println("Solution: After Method called - ");
		System.out.println(emp.getEmpoyeeId() + "---" + emp.getEmployeeName() + "---"
				+ emp.getDepartment().getId() + "---" + emp.getDepartment().getName());
	}
	
	static void updateGPSEmployee(final GPSEmployee emp) {
		emp.setEmpoyeeId(2);
		emp.setEmployeeName("Amit");		
		emp.getDepartment().setName("Sales");
	}
	
	static void updateEmployee(final Employee emp) {
		emp.setEmpoyeeId(2);
		emp.setEmployeeName("Amit");		
		emp.getDepartment().setName("Sales");
	}
}
