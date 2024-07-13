package com.xcode.javas.pakistanuniversity;
class Test
{
	public static void main(String args[])
	{
		Student s1=new Student("Arvind", 15);
		Student s2=new Student();

		s1.print();
		s2.print();

		s2.setName("Rajat");
		s2.setRollNo(14);

		System.out.print("Student name: "+s2.getName());
		System.out.println(" roll no.: "+s2.getRollNo());
		System.out.println("Calling copy constructure");
		Student s3=new Student(s2);

		s2.print();
		s3.print();

		s3.setRollNo(-10);

		s3.print();
	}
}

