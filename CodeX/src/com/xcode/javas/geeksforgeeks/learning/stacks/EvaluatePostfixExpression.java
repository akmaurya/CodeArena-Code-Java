package com.xcode.javas.geeksforgeeks.learning.stacks;
import java.util.*;

class EvaluatePostfixExpression
{
	public static void main(String ar[])
	{
		Scanner input = new Scanner(System.in);
		String expression = input.nextLine();
		evaluatePostfixExpression(expression);
	}

	public static void evaluatePostfixExpression(String expression)
	{
		int len=expression.length();
		com.xcode.javas.geeksforgeeks.learning.stacks.Stack stack = new com.xcode.javas.geeksforgeeks.learning.stacks.Stack(len);
		for(int i=0;i<len;i++)
		{
			if(isDigit(expression.charAt(i)))
				stack.push(expression.charAt(i));
			else
			{
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				switch(expression.charAt(i))
				{
					case '+':
							stack.push((char)(operand1+operand2));
							break;
					case '-':
							stack.push((char)(operand1-operand2));
							break;
					case '*':
							stack.push((char)(operand1*operand2));
							break;
					case '/':
							stack.push((char)(operand1/operand2));
							break;

				}
			}
		}
		System.out.println(stack.pop());
	}

	public static boolean isDigit(char ch)
	{
		return (ch>='0' && ch<='9');
	}
}