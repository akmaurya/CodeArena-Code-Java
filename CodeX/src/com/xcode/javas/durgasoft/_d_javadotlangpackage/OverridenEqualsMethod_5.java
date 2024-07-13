package com.xcode.javas.durgasoft._d_javadotlangpackage;

/**
 * Created by jarvis on 27/12/16.
 */
public class OverridenEqualsMethod_5
{
    public static void main(String[] args)
    {
        Student s1 = new Student("Durga", 101);
        Student s2 = new Student("Ravi", 102);
        Student s3 = new Student("Durga", 101);
        Student s4 = s1;

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));// Because this Object class equals() method is overriden in Student Class.
    }                                       //Uncomment that overriden equals() method in Student Class.
}
