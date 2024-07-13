package com.xcode.javas.hackerearth.basic_programming.input_output;

import java.util.Scanner;

/**
 * Created by jarvis on 30/6/17.
 */
public class Factorial
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int fact = 1;
        if (N == 1)
            System.out.println(1);
        else
        {
            for (int i = 2; i <= N; i++)
            {
                fact = fact * i;
            }
            System.out.println(fact);
        }
    }
}
