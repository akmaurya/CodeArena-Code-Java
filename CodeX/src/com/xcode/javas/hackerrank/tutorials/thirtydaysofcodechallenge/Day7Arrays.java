package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Day7Arrays
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = in.nextInt();
        }
        in.close();

        for(int i=n-1;i>=0;i--)
            System.out.print(arr[i]+" ");
    }
}


        /*
            Sample Input

            4
            1 4 3 2
            Sample Output

            2 3 4 1
        */