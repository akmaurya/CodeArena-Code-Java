package com.xcode.javas.hackerrank.datastructure.arrays;

import java.util.Scanner;

/**
 * Created by jelementvis on 26/10/16.
 */
class LeftRotation
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int r = input.nextInt();

        int temp1[] = new int[r];
        int temp2[] = new int[n-r];

        for(int i = 0; i < r; i++)
            temp1[i] = input.nextInt();
        for (int i = 0; i < n-r; i++)
        {
            temp2[i] = input.nextInt();
        }
        for(int i = 0; i < n-r; i++)
            System.out.print(temp2[i]+" ");
        for (int i = 0; i < r; i++)
        {
            System.out.print(temp1[i]+" ");
        }
    }
}


        /*
            Sample Input

            5 4
            1 2 3 4 5
            Sample Output

            5 1 2 3 4
        */