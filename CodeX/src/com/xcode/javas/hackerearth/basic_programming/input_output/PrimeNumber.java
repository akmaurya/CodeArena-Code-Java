package com.xcode.javas.hackerearth.basic_programming.input_output;

import java.util.Scanner;

/**
 * Created by jarvis on 30/6/17.
 */
public class PrimeNumber
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int count = 0;
        for (int i = 2; i <= N; i++)
        {
            count = 0;
            for (int j = 2; j <= i; j++)
            {
                if (i%j == 0)
                {
                    count++;
                }
            }
            if (count == 1)
                System.out.print(i+" ");
        }
    }
}
