package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 22/10/16.
 */
class Day16ExceptionsStringToInteger
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String S = input.next();
        try
        {
            int N = Integer.parseInt(S);
            System.out.println(N);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Bad String");
        }

    }
}


        /*
            Sample Input 0

            3
            Sample Output 0

            3
            Sample Input 1

            za
            Sample Output 1

            Bad String
        */