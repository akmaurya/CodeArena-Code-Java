package com.xcode.javas.geeksforgeeks.learning.stacks;
import java.util.*;
class InfixToPostfix
{
    public static void main(String ar[])
    {
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        InfixToPostfix.infixToPostfix(expression);
        
    }

    public static boolean isOperand(char ch)
    {
        return ((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'));
    }

    public static int precedenceOf(char ch)
    {
        switch(ch)
        {
            case '+':
            case '-':
                    return 1;
            case '*':
            case '/':
                    return 2;
            case '^':
                    return 3;
        }
        return -1;
    }

    public static void infixToPostfix(String expression)
    {
        int len = expression.length();
        String postfixExpression = "";
        StackChar stackChar = new StackChar(len);
        if(stackChar==null)
            return ;
        for(int i=0;i<len;i++)
        {
            if(isOperand(expression.charAt(i)))
                postfixExpression = postfixExpression+expression.charAt(i);
            else if(expression.charAt(i)=='(')
            {
                    stackChar.push(expression.charAt(i));
            }

            else if(expression.charAt(i)==')')
            {
                while(!stackChar.isEmpty() && stackChar.top()!='(')
                    postfixExpression=postfixExpression+stackChar.pop();
                if(!stackChar.isEmpty() && stackChar.top()!='(')
                    return ;
                else 
                    stackChar.pop();
            }

            else
            {
                while(!stackChar.isEmpty() && precedenceOf(expression.charAt(i))<precedenceOf(stackChar.top()))
                    postfixExpression = postfixExpression+stackChar.pop();
                stackChar.push(expression.charAt(i));
            }
        }

        while(!stackChar.isEmpty())
            postfixExpression = postfixExpression+stackChar.pop();
        System.out.println(postfixExpression);
    }
}