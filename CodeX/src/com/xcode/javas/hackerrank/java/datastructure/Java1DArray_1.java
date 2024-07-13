package com.xcode.javas.hackerrank.java.datastructure;

import java.util.Scanner;

/**
 * Created by jarvis on 7/1/17.
 */
public class Java1DArray_1
{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for(int i = 0 ; i < n; i++){
            int val = scan.nextInt();
            a[i] = val;
            // Fill array a here
        }
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}


        /*
            Sample Input

            5
            10
            20
            30
            40
            50
            Sample Output

            10
            20
            30
            40
            50
        */