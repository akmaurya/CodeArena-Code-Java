package com.xcode.javas.durgasoft._c_jvmarchitecture;

class Student
{
	String name;
	int roll;

	Student(String name, int roll)
	{
		this.name=name;
		this.roll=roll;
	}

	public static void main(String args[])
	{
		Student s1=new Student("Arvind", 101);
		Student s2=new Student("Rajat", 102);

		System.out.println(s1);
		System.out.println(s2);

	}
}