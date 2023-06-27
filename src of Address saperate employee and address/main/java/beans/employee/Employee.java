package beans.employee;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	private static int id=1;
	private String name;
	private float salary;
	private String designation;

	public int getId() { 
		return id;
	}

	public void setId(int id) {
		if(Employee.id==1)
			Employee.id=1;
		else
			Employee.id = Employee.id+1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", designation=" + designation + "]";
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
}