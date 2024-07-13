package com.xcode.javas.geeksforgeeks.learning.stacks;
import java.util.*;

class Solution2
{

    static int top=-1;
    static Integer arr[];
    static int maxSize;

    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        arr = new Integer[N];
        while(N--!=0)
        {
            int n = input.nextInt();
            int x;
            if(n==1)
            {
                x = input.nextInt();
                push(x);
            }
            else if(n==2)
                pop();
            else if(n==3)
                front();
            System.out.println("Printing-"+n+"_top-"+top);
        }
        
    }
    
    public static void push(int element)
    {
    	System.out.println("Printing-1");
        if(top<maxSize)
        {
        	top=top+1;
            arr[top] = element;
        }
        else
            return;
    }
    
    public static int pop()
    {
    	System.out.println("Printing-2");
        if(top>-1)
        {
            return arr[top--];
        }
        else
            return 0;
    }
    
    public static void front()
    {
    	System.out.println("Printing-3");
        if(top>-1)
            System.out.println(arr[top]);
        else
            return;
    }
}