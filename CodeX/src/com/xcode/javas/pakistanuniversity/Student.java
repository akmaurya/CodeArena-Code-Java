package com.xcode.javas.pakistanuniversity;
class Student
{
	private String name;
	private int rollNo;

	public void setName(String name)
	{
		this.name=name;
	}

	public void setRollNo(int rollNo)
	{
		if(rollNo>0)
			this.rollNo=rollNo;
		else
			this.rollNo=100;
	}

	public String getName()
	{
		return name;
	}

	public int getRollNo()
	{
		return rollNo;
	}

	public Student()
	{
		name="not set";
		rollNo=100;
	}

	public Student(String name, int rollNo)
	{
		setName(name);
		setRollNo(rollNo);
	}

	public Student(Student s)
	{
		name=s.name;
		rollNo=s.rollNo;
	}

	public void print()
	{
		System.out.println("Student name: " + name+", roll no: "+rollNo);
	}
}

