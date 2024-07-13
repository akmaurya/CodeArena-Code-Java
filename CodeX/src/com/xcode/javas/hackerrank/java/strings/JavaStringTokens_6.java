package com.xcode.javas.hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by jarvis on 7/1/17.
 */
public class JavaStringTokens_6
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(s.trim());
        String[] token=s.trim().split("[ !,?\\._'@]+",0);
        if(token.length==1 && token[0].equals("")){
            System.out.println(0);
        }else
        {
            System.out.println(token.length);
            for (String tokens : token) System.out.println(tokens);
        }
        scan.close();
    }
}


    /*
    He9is9a9very9very9good9boy,9isn't9he?
        Sample Input

        He is a very very good boy, isn't he?
        Sample Output

        10
        He
        is
        a
        very
        very
        good
        boy
        isn
        t
        he
    */