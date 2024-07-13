package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 25/10/16.
 */
public class Day29BitwiseAND
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t-- != 0)
        {
            int N = input.nextInt();
            int K = input.nextInt();
            int p = 0;
            int i=0;
            int bitAnd;
            int pp = 0;
            for (int a = 1; a <= N; a++)
            {
                for (int b = a + 1; b <= N; b++)
                {
                    bitAnd = a & b;
                    if (bitAnd < K && bitAnd >= pp)
                    {
                        p = bitAnd;
                        pp = bitAnd;
                    }
                }
            }
            System.out.println(p);
        }
    }
}


        /*
            Sample Input

            3
            5 2
            8 5
            2 2
            Sample Output

            1
            4
            0
        */