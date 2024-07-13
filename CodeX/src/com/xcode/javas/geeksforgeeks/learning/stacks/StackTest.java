package com.xcode.javas.geeksforgeeks.learning.stacks;
import java.util.*;

class StackTest
{
	static int stackSize;
	static com.xcode.javas.geeksforgeeks.learning.stacks.Stack stack;
	static Scanner input;
	public void stackTest()
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
					StackTest.createStack();
					break;

			case 2:
					Test test = new Test();
					test.testMenu();

			default:
					StackTest.stackMenu();
		}
	}

	public static void createStack()
	{
		System.out.println("Enter the size of stack");
		stackSize = input.nextInt();
		stack = new com.xcode.javas.geeksforgeeks.learning.stacks.Stack(stackSize);
		System.out.println("Stack is created of size "+stackSize);
		StackTest.stackOperations();

	}

	public static void stackOperations()
	{
		int choice;
		do
		{
			System.out.println("1-Push\n2-Pop\n3-Top\n4-Is Empty\n5-Exit\n\n\nEnter Your Choice");
			choice = input.nextInt();
			switch(choice)
			{
				case 1:
						System.out.println("Enter element");
						stack.push(input.nextInt());
						break;

				case 2:
						stack.pop();
						break;

				case 3:
						System.out.println("Top element is "+stack.top());
						break;

				case 4:
						if(stack.isEmpty())
							System.out.println("Yes");
						else 
							System.out.println("No");
						break;
				
				case 5:
						System.exit(0);
				default:
						StackTest.stackOperations();
			}	
		}while(choice!=5);
		
	}
}