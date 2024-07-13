package com.xcode.javas.rough.classandobject;

class A
{
	public static void main(String ar[])
	{
		B obj=new B();
		obj.print();
	}
}

class B
{
	public void print()
	{
		System.out.println("This is a function of another class.");
	}
}