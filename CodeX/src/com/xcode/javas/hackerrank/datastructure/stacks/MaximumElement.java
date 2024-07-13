package com.xcode.javas.hackerrank.datastructure.stacks;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class MaximumElement
{
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

    public static void pop()
    {
        if(top>-1)
            top--;

    }

    public static void top()
    {
        if(top>-1)
            System.out.println(large());
    }

    public static int large()
    {
        int max=arr[0];
        for(int i=1; i<=top; i++) {
            if(max<arr[i])
                max = arr[i];
        }

        return max;
    }
}


        /*
            Sample Input

            10
            1 97
            2
            1 20
            2
            1 26
            1 20
            2
            3
            1 91
            3
            Sample Output

            26
            91
        */