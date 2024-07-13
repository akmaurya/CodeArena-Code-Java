package com.xcode.javas.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Staircase
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            for(int j=n;j>i+1;j--)
                System.out.print(" ");
            for(int j=0;j<=i;j++)
                System.out.print("#");
            System.out.println();
        }
    }
}


        /*
            Sample Input

            6
            Sample Output

                 #
                ##
               ###
              ####
             #####
            ######
        */