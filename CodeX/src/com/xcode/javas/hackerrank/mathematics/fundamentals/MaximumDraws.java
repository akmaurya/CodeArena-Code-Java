package com.xcode.javas.hackerrank.mathematics.fundamentals;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class MaximumDraws
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int T;
        Scanner input =new Scanner(System.in);
        T = input.nextInt();
        while(T--!=0)
        {
            int n = input.nextInt();
            System.out.println(n+1);
        }
    }
}


        /*
            Sample Input

            2
            1
            2
            Sample Output

            2
            3
        */