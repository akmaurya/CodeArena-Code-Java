package com.xcode.javas.hackerrank.java.strings;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by jarvis on 7/1/17.
 */
public class PatternSyntaxChecker_7
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();
            //Write your code

            try
            {
                Pattern.compile(pattern);
                System.out.println("Valid");
            }
            catch (Exception e)
            {
                System.out.println("Invalid");
            }

        }
    }
}


        /*
            Sample Input

            3
            ([A-Z])(.+)
            [AZ[a-z](a-z)
            batcatpat(nat
            Sample Output

            Valid
            Invalid
            Invalid
        */