package com.xcode.javas.geeksforgeeks.learning.stacks;

import java.util.*;
class TwoStackInOneArrayTest
{
	static int stackSize;
	static TwoStackInOneArray twoStackInOneArray;
	static Scanner input;
	public TwoStackInOneArrayTest()
    {

    }

	public static void stackMenu()
	{
		System.out.println("1-Create Stack\n2-Back\n3-Exit\n\n\nEnter Your Choice");
		input = new Scanner(System.in);
		int choice = input.nextInt();
		
		switch(choice)
		{
			case 1:
					TwoStackInOneArrayTest.createStack();
					break;

			case 2:
					Test test = new Test();
					test.testMenu();

			default:
					TwoStackInOneArrayTest.stackMenu();
		}
	}

	public static void createStack()
	{
		System.out.println("Enter the size of Array");
		stackSize = input.nextInt();
		twoStackInOneArray = new TwoStackInOneArray(stackSize);
		System.out.println("Stack is created of size "+stackSize);
		TwoStackInOneArrayTest.stackOperations();

	}

	public static void stackOperations()
	{
		int choice;
		do
		{
			System.out.println("1-Push1\n2-Push2\n3-Pop1\n4-Pop2\n5-Exit\n\n\nEnter Your Choice");
			choice = input.nextInt();
			switch(choice)
			{
				case 1:
						System.out.println("Enter element");
						twoStackInOneArray.push1(input.nextInt());
						break;

				case 2:
						System.out.println("Enter element");
						twoStackInOneArray.push2(input.nextInt());
						break;
				case 3:
						twoStackInOneArray.pop1();
						break;
				

				case 4:
						twoStackInOneArray.pop2();
						break;
				
				case 5:
						System.exit(0);
				default:
						TwoStackInOneArrayTest.stackOperations();
			}	
		}while(choice!=5);
		
	}
}