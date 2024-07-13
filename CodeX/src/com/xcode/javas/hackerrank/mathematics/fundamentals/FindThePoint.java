package com.xcode.javas.hackerrank.mathematics.fundamentals;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class FindThePoint
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        while(T--!=0)
        {
            int x1 = input.nextInt();
            int y1 = input.nextInt();
            int x2 = input.nextInt();
            int y2 = input.nextInt();
            int x3=x2, y3=y2;
            if(x1<x2)
                x3 = x2+x2-x1;
            if(x1>x2)
                x3 = x2-x1+x2;
            if(y1<y2)
                y3 = y2+y2-y1;
            if(y1>y2)
                y3 = y2-y1+y2;
            System.out.println(x3+" "+y3);
        }

    }
}


        /*
            Sample Input

            2
            0 0 1 1
            1 1 2 2
            Sample Output

            2 2
            3 3
        */