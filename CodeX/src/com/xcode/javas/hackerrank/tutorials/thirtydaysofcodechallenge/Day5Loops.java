package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Day5Loops
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i=1;i<=10;i++)
        {
            System.out.println(n+" x "+i+" = "+(i*n))   ;
        }
    }
}


        /*
            Sample Input

            2
            Sample Output

            2 x 1 = 2
            2 x 2 = 4
            2 x 3 = 6
            2 x 4 = 8
            2 x 5 = 10
            2 x 6 = 12
            2 x 7 = 14
            2 x 8 = 16
            2 x 9 = 18
            2 x 10 = 20
        */