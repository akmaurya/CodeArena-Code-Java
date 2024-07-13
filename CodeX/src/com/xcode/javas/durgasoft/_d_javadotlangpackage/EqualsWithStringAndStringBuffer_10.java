package com.xcode.javas.durgasoft._d_javadotlangpackage;

/**
 * Created by jarvis on 27/12/16.
 */
public class EqualsWithStringAndStringBuffer_10
{
    public static void main(String[] args)
    {
        String s1 = new String("Durga");
        String s2 = new String("Durga");

        System.out.println("String Class :");
        System.out.println("System.out.println(s1 == s2);--"+ (s1 == s2));
        System.out.println("System.out.println(s1.equals(s2));--"+s1.equals(s2));

        StringBuffer sb1 = new StringBuffer("Durga");
        StringBuffer sb2 = new StringBuffer("Durga");

        System.out.println("\n\nStringBuffer Class :");
        System.out.println("System.out.println(sb1 == sb2);--"+ (sb1 == sb2));
        System.out.println("System.out.println(sb1.equals(sb2));--"+sb1.equals(sb2));
        //Because in StringBuffer Class equals() method is not overridden.
    }
}
