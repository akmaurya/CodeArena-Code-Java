package com.xcode.javas.hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by jarvis on 7/11/16.
 */
class JavaStaticInitializerBlock
{
    static boolean flag = false;
    static int B, H;
    static
    {
        Scanner input = new Scanner(System.in);
        B = input.nextInt();
        H = input.nextInt();
        try
        {
            if (B <= 0 || H <=0)
                throw new Exception("java.lang.Exception: Breadth and height must be positive");
            else
                flag = true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main
}


        /*
            Sample input 1

            1
            3
            Sample output 1

            3
            Sample input 2

            -1
            2
            Sample output 2

            java.lang.Exception: Breadth and height must be positive
        */