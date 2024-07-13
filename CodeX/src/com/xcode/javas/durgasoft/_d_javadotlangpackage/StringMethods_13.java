package com.xcode.javas.durgasoft._d_javadotlangpackage;

/**
 * Created by jarvis on 27/12/16.
 */
public class StringMethods_13
{
    public static void main(String[] args)
    {
        String s = "Durga";
        System.out.println(s.charAt(3));
        //System.out.println(s.charAt(30));

        s = s.concat("Software");
        s = s+"Software";
        s += "Software";
        System.out.println(s);

        System.out.println(s.equals("DurgaSoftware"));

        System.out.println(s.equalsIgnoreCase("DurgaSoftwaresoftwaresoftware"));

        System.out.println(s.substring(15));
        System.out.println(s.substring(11,15));

        System.out.println(s.length());

        System.out.println(s.replace('a', 'b'));//It will not affect the s object because it is immutable.

        System.out.println(s.trim());

        System.out.println(s.indexOf('b'));

        System.out.println(s.lastIndexOf('a'));
    }
}
