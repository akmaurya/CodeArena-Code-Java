package com.xcode.javas.hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by jarvis on 7/1/17.
 */
public class JavaStringReverse_4
{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        for (int i = 0; i <= A.length()/2; i++)
        {
            if (A.charAt(i) == A.charAt(A.length()-i-1))
            {
                continue;
            }
            else
            {
                System.out.println("No");
                System.exit(1);
            }
        }
        System.out.println("Yes");
        /* Enter your code here. Print output to STDOUT. */

    }
}


    /*
        Sample Input

        madam
        Sample Output

        Yes
    */