package com.xcode.javas.durgasoft._d_javadotlangpackage;

/**
 * Created by jarvis on 27/12/16.
 */
public class EqualsMethod_4
{
    public static void main(String[] args)
    {
        Student s1 = new Student("Durga", 101);
        Student s2 = new Student("Ravi", 102);
        Student s3 = new Student("Durga", 101);
        Student s4 = s1;

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));// Because this Object class equals() method meant for reference comparison.
    }
}

class Student
{
    private String name;
    private int rollNo;

    public Student(String name, int rollNo)
    {
        this.name = name;
        this.rollNo = rollNo;
    }

//    public boolean equals(Object obj)
//    {
//        String name1 = this.name;
//        int rollNo1 = this.rollNo;
//
//        Student s = (Student)obj;
//        String name2 = s.name;
//        int rollNo2 = s.rollNo;
//
//        if (name1.equals(name2) && rollNo1 == rollNo2)
//            return true;
//        else
//            return false;
//    }
}
