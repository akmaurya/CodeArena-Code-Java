package com.xcode.javas.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class PlusMinus
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int mns=0,pls=0,zero=0;
        Integer array[]=new Integer[n];

        for(int i=0;i<n;i++)
        {
            array[i]=sc.nextInt();
            if(array[i]<0)
                mns+=1;
            else if(array[i]>0)
                pls+=1;
            else
                zero+=1;
        }
        double one=(Double.valueOf(pls))/n;
        double two=(Double.valueOf(mns))/n;
        double three=(Double.valueOf(zero))/n;

        System.out.println(""+one);
        System.out.println(""+two);
        System.out.println(""+three);

    }
}


        /*
            Sample Input

            6
            -4 3 -9 0 4 1
            Sample Output

            0.500000
            0.333333
            0.166667
        */