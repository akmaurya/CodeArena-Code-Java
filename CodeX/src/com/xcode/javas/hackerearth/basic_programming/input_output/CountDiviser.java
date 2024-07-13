package com.xcode.javas.hackerearth.basic_programming.input_output;

import java.util.Scanner;

/**
 * Created by jarvis on 30/6/17.
 */
public class CountDiviser
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int l = input.nextInt();
        int r = input.nextInt();
        int k = input.nextInt();
        int count = 0;
        for (int i = l; i <= r; i++)
        {
            if (i%k == 0)
                count++;
        }
        System.out.println(count);
    }
}
