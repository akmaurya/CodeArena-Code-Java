package com.xcode.javas.geeksforgeeks.learning.stacks;
import java.util.*;
class ReverseString
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		reverseString(str);
	}

	public static void reverseString(String str)
	{
		int len = str.length();
		StackChar stackChar = new StackChar(len);
		for(int i=0;i<len;i++)
			stackChar.push(str.charAt(i));
		while(!stackChar.isEmpty())
		{
			System.out.print(stackChar.pop());
		}
	}
}