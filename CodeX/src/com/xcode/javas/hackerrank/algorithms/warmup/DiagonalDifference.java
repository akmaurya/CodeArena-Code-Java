package com.xcode.javas.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class DiagonalDifference
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Integer matrix[][]=new Integer[n][n];

        int onDia=0,offDia=0;

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.nextInt();
                if(i==j&&(i+j)!=n-1)
                {
                    onDia+=matrix[i][j];

                }
                else if(i!=j&&(i+j)==n-1)
                {
                    offDia+=matrix[i][j];

                }
            }

        System.out.println(Math.abs(onDia-offDia));
    }
}


        /*
            Sample Input

            3
            11 2 4
            4 5 6
            10 8 -12
            Sample Output

            15
        */