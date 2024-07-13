package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Day8DictionariesAndMaps
{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Map m = new HashMap();

        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            m.put(name,""+phone);

        }
        while(in.hasNext()){
            String s = in.next();
            int flag=0;
            // Write code here
            if(m.containsKey(s))
                System.out.println(s+"="+m.get(s));
            else
                System.out.println("Not found");
        }
        in.close();
    }
}


        /*
            Sample Input

            3
            sam 99912222
            tom 11122222
            harry 12299933
            sam
            edward
            harry
            Sample Output

            sam=99912222
            Not found
            harry=12299933
        */