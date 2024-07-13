package com.xcode.javas.geeksforgeeks.learning.stacks;
import java.util.*;

class Solution3 {

    static int top=-1;
    static Integer arr[];
    static int maxSize;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        arr = new Integer[N];
        maxSize = N;
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
                top();
                
        }
        
    }
    
    public static void push(int element)
    {
        if(top<maxSize)
            arr[++top] = element;
    }
    
    public static int pop()
    {
        if(top>-1)
            return arr[top--];
        else
            return 0;
    }
    
    public static void top()
    {
        if(top>-1)
            System.out.println();
        else
            return;
    }

    
}