package com.xcode.javas.durgasoft._d_javadotlangpackage;

/**
 * Created by jarvis on 27/12/16.
 */
public class Cloning_6 implements Cloneable
{
    int i = 10;
    int j = 20;
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Cloning_6 c1 = new Cloning_6();
        Cloning_6 c2 = (Cloning_6) c1.clone();

        c2.i = 888;
        c2.j = 999;

        System.out.println(c1.i+"----"+c1.j);
        System.out.println(c2.i+"----"+c2.j);
    }
}
