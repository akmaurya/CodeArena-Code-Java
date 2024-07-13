package com.xcode.javas.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class AVeryBigSum
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        long sum=0;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Integer nos[]=new Integer[n];

        for(int i=0;i<n;i++)
        {
            nos[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++)
        {
            sum=sum+nos[i];
        }
        System.out.print(sum);
    }
}


        /*
            Sample Input

            5
            1000000001 1000000002 1000000003 1000000004 1000000005
            Output

            5000000015
        */