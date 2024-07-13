package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 22/10/16.
 */
class Calculator
{
    public int power(int num, int pow) throws Exception
    {
        int result = 1;
        if (num < 0 || pow < 0)
        {
            throw new Exception("n and p should be non-negative");
        }
        else
        {
            if (pow == 1)
                return num;
            else if (pow == 0)
                return 1;
            else
            {
                for (int i = 1; i <= pow; i++)
                {
                    result = result * num;
                }
                return result;
            }
        }

    }
}

class Day17MoreExceptions
{
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        while(T-->0)
        {
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try
            {
                int ans=myCalculator.power(n,p);
                System.out.println(ans);

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

    }
}


        /*
            Sample Input

            4
            3 5
            2 4
            -1 -2
            -1 3
            Sample Output

            243
            16
            n and p should be non-negative
            n and p should be non-negative
        */