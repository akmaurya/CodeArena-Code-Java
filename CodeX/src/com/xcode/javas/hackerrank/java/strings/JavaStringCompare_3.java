package com.xcode.javas.hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by jarvis on 6/1/17.
 */
public class JavaStringCompare_3
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int subLen = input.nextInt();

        String subMax = s.substring(0,subLen);
        String subMin = s.substring(0,subLen);
        for (int i = 1; i<=(s.length()-subLen); i++)
        {
            System.out.println(subMax+"-----"+s.substring(i,i+subLen)+"....................."+subMin+"-----"+s.substring(i,i+subLen));
            if(subMax.compareTo(s.substring(i,i+subLen))<0?true:false)
            {
                subMax = s.substring(i,i+subLen);
            }
            if(subMin.compareTo(s.substring(i,i+subLen))>0?true:false)
            {
                subMin = s.substring(i,i+subLen);
            }
        }
        System.out.println(subMin+"\n"+subMax);
    }
}


        /*
            Sample Input

            welcometojava
            3
            Sample Output

            ava
            wel
        */