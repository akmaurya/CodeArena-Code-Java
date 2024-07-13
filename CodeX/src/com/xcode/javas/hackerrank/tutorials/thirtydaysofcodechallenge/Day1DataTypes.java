package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Day1DataTypes
{
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);
        /* Declare second integer, double, and String variables. */
        int ii;
        double dd;
        String ss;
        /* Read and save an integer, double, and String to your variables.*/
        ii=scan.nextInt();
        dd=scan.nextDouble();
        ss=scan.nextLine();
        ss=scan.nextLine();
        /* Print the sum of both integer variables on a new line. */
        System.out.println(i+ii);
        /* Print the sum of the double variables on a new line. */
        System.out.println(d+dd);

        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
        System.out.println(s+ss);
        scan.close();
    }
}


        /*
            Sample Input

            12
            4.0
            is the best place to learn and practice coding!
            Sample Output

            16
            8.0
            HackerRank is the best place to learn and practice coding!
        */
