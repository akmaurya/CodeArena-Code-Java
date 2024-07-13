package com.xcode.javas.geeksforgeeks.learning.stacks;

class TwoStackInOneArray
{
	static Integer array[];
	static int top1, top2;
	static int stackSize;



    public TwoStackInOneArray(int size)
	{
		stackSize=size;
		array = new Integer[size];
		top1=-1;
		top2=size;
	}

	public static void push1(int element)
	{
		if(top1<top2-1)
			array[++top1]=element;
		else
			System.out.println("Stack Overflow");
	}

	public static void push2(int element)
	{
		if(top1<top2-1)
			array[--top2]=element;
		else
			System.out.println("Stack Overflow");		
	}

	public static int pop1()
	{
		if(top1<0)
		{
			System.out.println("Stack Underflow");
			return 0;
		}
		else
		{
			return array[top1--];
		}
	}

	public static int pop2()
	{
		if(top2>stackSize)
		{
			System.out.println("Stack Underflow");
			return 0;
		}
		else
		{
			return array[top2++];
		}
	}
}