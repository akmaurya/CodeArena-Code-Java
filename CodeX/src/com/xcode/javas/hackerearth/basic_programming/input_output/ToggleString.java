package com.xcode.javas.hackerearth.basic_programming.input_output;

/**
 * Created by jarvis on 30/6/17.
 */
import java.util.*;

public class ToggleString{
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
        */
        //BufferedReader

        //Scanner
        Scanner s = new Scanner(System.in);
        String  str = s.nextLine();
        String str2 = "";
        for(int i = 0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z')
                str2 = str2+(char)(ch-32);
            if(ch >= 'A' && ch <= 'Z')
                str2 = str2+(char)(ch+32);
        }
        System.out.println(str2);
    }
}
