package com.xcode.javas.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class SimpleArraySum
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int t,n,s=0;

        Scanner cn=new Scanner(System.in);
        t=cn.nextInt();

        int string[]=new int[t];

        for(int i=0;i<t;i++)
        {
            string[i]=cn.nextInt();
            s=s+string[i];
        }
        System.out.println(s);

    }
}


        /*
            Sample Input

            6
            1 2 3 4 10 11
            Sample Output

            31
        */