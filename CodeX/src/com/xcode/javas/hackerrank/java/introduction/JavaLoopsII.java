package com.xcode.javas.hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by jarvis on 21/10/16.
 */
class JavaLoopsII
{
    public static void main(String []argh){
        JavaLoopsII ob = new JavaLoopsII();
        Scanner in = new Scanner(System.in);
        int sum = 0;
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int j = 0; j < n; j++)
            {
                sum = 0;
                for (int k = 0; k <=j; k++)
                {
                    sum = sum+(ob.pow(2,k)*b);
                    //System.out.println(ob.pow(2,k));
                }
                System.out.print(a+sum+" ");
            }
            System.out.println();
        }
        in.close();
    }
    public int pow(int number, int power)
    {
        int result = 1;
        if (power == 1)
            return number;
        else if (power == 0)
            return 1;
        else
        {
            for (int i = 1; i <= power; i++)
            {
                result = result * number;
            }
            return result;
        }
    }
}


        /*
            Sample Input

            2
            0 2 10
            5 3 5
            Sample Output

            2 6 14 30 62 126 254 510 1022 2046
            8 14 26 50 98
        */