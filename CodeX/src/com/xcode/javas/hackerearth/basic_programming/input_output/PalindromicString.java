package com.xcode.javas.hackerearth.basic_programming.input_output;

import java.util.Scanner;

/**
 * Created by jarvis on 30/6/17.
 */
public class PalindromicString
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int len = str.length();
        boolean flag = true;
        for (int i = 0; i < len/2; i++)
        {
               if (str.charAt(i) != str.charAt(len-i-1))
               {
                   System.out.print("NO");
                   flag = false;
                   break;
               }
        }
        if (flag == true)
            System.out.println("YES");
    }
}
