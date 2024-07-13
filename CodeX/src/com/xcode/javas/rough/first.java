package com.xcode.javas.rough;

import java.util.Scanner;

class first1
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();

		first1 obj=new first1();
		int result=obj.add(a,b);

		System.out.println(""+result);
	}

	public int add(int a, int b)
	{
		return a+b;
	}

}