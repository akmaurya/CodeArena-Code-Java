package com.xcode.javas.geeksforgeeks.learning.stacks;
class StackChar
{
    static Character stack[];
    static int top=-1;
    static int stackSize;
    public StackChar(int size)
    {
        stackSize=size;
        stack = new Character[stackSize];
    }

    public static void push(char element)
    {
        if(top==stackSize-1)
        {
            System.out.println("Stack Overflow");
            return;
        }
        
        stack[++top]=element;
    }

    public static char pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow");
            return 0;
        }

        return stack[top--];
        
    }

    public static boolean isEmpty()
    {
        if(top==-1)
            return true;
        else
            return false;
    }

    public static char top()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow");
            return 0;
        }
        return stack[top];
    }
}