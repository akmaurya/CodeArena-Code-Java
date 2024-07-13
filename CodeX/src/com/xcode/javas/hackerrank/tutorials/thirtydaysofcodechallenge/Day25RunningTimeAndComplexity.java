package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 25/10/16.
 */
class Day25RunningTimeAndComplexity
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int j = 0;
        for (int i = 0; i < t; i++)
        {
            int n = input.nextInt();
            if (n == 1)
                System.out.println("Not prime");
            else
            {
                for (j = 2; j <= Math.sqrt((double) n); j++)
                {
                    if (n%j == 0)
                    {
                        System.out.println("Not prime");
                        break;
                    }
                }
                if (j > Math.sqrt((double) n))
                {
                    System.out.println("Prime");
                }
            }
        }
    }

}


        /*
            Sample Input

            3
            12
            5
            7
            Sample Output

            Not prime
            Prime
            Prime
        */