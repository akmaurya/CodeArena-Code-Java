package com.xcode.javas.other.java8features;

public class LambdaWithMethodReference
{
    public static void main(String[] args)
    {
        String str = "nav";
        MyPrinter mp = new MyPrinter();
        mp.print(str, (StringParser::convert));
    }
}


interface Parse
{
    String parse(String str);
}


class StringParser
{
    public static String convert(String str)
    {
        if (str.length()<=3)
            str = str.toUpperCase();
        else
            str = str.toLowerCase();
        return str;
    }
}


class MyPrinter
{
    public void print(String str, Parse p)
    {
        str = p.parse(str);
        System.out.println(str);
    }
}