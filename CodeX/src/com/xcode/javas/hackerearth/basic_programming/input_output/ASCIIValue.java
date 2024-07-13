package com.xcode.javas.hackerearth.basic_programming.input_output;

import java.util.Scanner;

/**
 * Created by jarvis on 26/7/17.
 */
public class ASCIIValue
{
    public static void main(String[] args)
    {
        Scanner input =new Scanner(System.in);
        char ch = input.next().charAt(0);
        System.out.println((int)ch);


    }
}
