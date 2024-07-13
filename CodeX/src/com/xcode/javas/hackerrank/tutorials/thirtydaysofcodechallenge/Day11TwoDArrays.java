package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Day11TwoDArrays
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++)
        {
            for(int j=0; j < 6; j++)
            {
                arr[i][j] = in.nextInt();
            }
        }

        int sum[][]=new int[4][4];

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                sum[i][j]=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2]+arr[i+1][j+1];
            }
        }
        int max=sum[0][0];
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(max<sum[i][j])
                    max=sum[i][j];
            }
        }
        System.out.print(max);
    }
}


        /*
            Sample Input

            1 1 1 0 0 0
            0 1 0 0 0 0
            1 1 1 0 0 0
            0 0 2 4 4 0
            0 0 0 2 0 0
            0 0 1 2 4 0
            Sample Output

            19
        */