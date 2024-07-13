package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 24/10/16.
 */
class Day20Sorting
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int countSwap = 0;
        int swap = 0;
        int n = input.nextInt();
        Integer a[] = new Integer[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++)
        {
            swap = 0;
            for (int j = 0; j < n-1; j++)
            {
                if (a[j] > a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swap++;
                    countSwap++;
                }
            }
            if(swap == 0)
                break;
        }
        System.out.println("Array is sorted in " +countSwap+" swaps.");
        System.out.println("First Element: " +a[0]);
        System.out.println("Last Element: " +a[n-1]);
    }
}


        /*
            Sample Input 0

            3
            1 2 3
            Sample Output 0

            Array is sorted in 0 swaps.
            First Element: 1
            Last Element: 3
            Sample Input 1

            3
            3 2 1
            Sample Output 1

            Array is sorted in 3 swaps.
            First Element: 1
            Last Element: 3
        */