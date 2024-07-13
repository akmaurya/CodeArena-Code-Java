package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 25/10/16.
 */
class Day26NestedLogic
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int Date[][] = new int[2][3];

        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Date[i][j] = input.nextInt();
            }
        }

        int fine = 0;
        if (Date[0][2] > Date[1][2])
        {
            fine = 10000;
        }
        else if (Date[0][2] == Date[1][2])
        {
            if (Date[0][1] > Date[1][1])
            {
                fine = (Date[0][1] - Date[1][1]) * 500;
            }
            else if (Date[0][1] == Date[1][1])
            {
                if (Date[0][0] > Date[1][0])
                    fine = (Date[0][0] - Date[1][0])*15;
                else
                    fine = 0;
            }
            else
                fine = 0;
        }
        else
            fine = 0;
        System.out.println(fine);
    }
}


        /*
            Sample Input

            9 6 2015
            6 6 2015
            Sample Output

            45
        */