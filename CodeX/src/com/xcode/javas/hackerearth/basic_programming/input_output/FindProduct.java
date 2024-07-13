package com.xcode.javas.hackerearth.basic_programming.input_output;

import java.util.Scanner;

/**
 * Created by jarvis on 30/6/17.
 */
public class FindProduct
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Integer array[] = new Integer[N];

        long result = 1;
        for (int i = 0; i < N; i++)
        {
            array[i] = input.nextInt();
            result = (result*array[i])%1000000007;
        }
        System.out.println(result);
    }
}
