package com.xcode.javas.durgasoft._d_javadotlangpackage;

/**
 * Created by jarvis on 27/12/16.
 */
public class StringAndStringBuffer_11
{
    public static void main(String[] args)
    {
        String s = new String("Durga");
        s.concat("Software");
        System.out.println(s);

        StringBuffer sb = new StringBuffer("Durga");
        sb.append("Software");
        System.out.println(sb);
    }
}
