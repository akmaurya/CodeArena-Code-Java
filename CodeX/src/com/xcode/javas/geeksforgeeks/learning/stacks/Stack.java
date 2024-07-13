package com.xcode.javas.geeksforgeeks.learning.stacks;
class Stack
{
    static Integer stack[];
    static int top=-1;
    static int stackSize;
    public Stack(int size)
    {
        stackSize=size;
        stack = new Integer[stackSize];
    }

    public static void push(int element)
    {
        if(top==stackSize-1)
        {
            System.out.println("Stack Overflow");
            return;
        }
        
        stack[++top]=element;
    }

    public static int pop()
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

    public static int top()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow");
            return 0;
        }
        return stack[top];
    }
}