package com.xcode.javas.hackerearth.basic_programming.input_output;

import java.util.Scanner;

/**
 * Created by jarvis on 26/7/17.
 */
public class LifeTheUniverseAndEverything
{
    public static void main(String[] args)
    {
        int i = 0;
        Scanner input = new Scanner(System.in);
        do
        {
            i = input.nextInt();
            if (i != 42)
                System.out.println(i);
        }while (i != 42);
    }
}
