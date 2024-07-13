package com.xcode.javas.geeksforgeeks.learning.stacks;
import java.util.*;
class Test
{
	public static void main(String[] args) 
	{
		Test test = new Test();
		test.testMenu();
	}
	public static void testMenu()
	{
		System.out.println("1-Stack\n2-Two Stack In One Array\n0-Exit\n\n\nEnter Your Choice");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		switch(choice)
		{
			case 1:
				StackTest stackTest = new StackTest();
				stackTest.stackMenu();
				break;
			case 2:
				TwoStackInOneArrayTest twoStackInOneArraytest =new TwoStackInOneArrayTest();
				twoStackInOneArraytest.stackMenu();
			default:
				System.exit(0);
		}
	}

	
}