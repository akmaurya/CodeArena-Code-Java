package com.xcode.javas.hackerrank.datastructure.arrays;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class ArraysDS
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Integer A[] = new Integer[N];
        for(int i = 0;i<N;i++)
            A[i] = input.nextInt();
        for(int i=N-1;i>=0;i--)
            System.out.print(A[i]+" ");
    }
}


       /*
           Sample Input

           4
           1 4 3 2
           Sample Output

           2 3 4 1
       */