package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Day9Recursion
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Day9Recursion ob = new Day9Recursion();
        System.out.print(ob.factorial(n));
    }

    public static int factorial(int n)
    {
        int f=1;
        if(n>1)
            f=n*factorial(n-1);
        return f;
    }
}


        /*
            Sample Input

            3
            Sample Output

            6
        */