package com.xcode.javas.preparation.java8feature;


interface Test{
    public void m1();
    public void m2();

    default void m3(){
        System.out.println("This is m3 default method");
    }
    default void m4(){
        System.out.println("This is m4 default method");
    }
    static void m5(){
        System.out.println("This is m5 default method");
    }
}
public class DefaultMethodInInterface implements Test
{
    public static void main(String[] args)
    {
        DefaultMethodInInterface obj = new DefaultMethodInInterface();
        obj.m1();
        obj.m2();
        obj.m3();
        obj.m4();
        Test.m5();
    }

    @Override
    public void m1()
    {
        System.out.println("Method m1");
    }

    @Override
    public void m2()
    {
        System.out.println("Method m2");
    }
}
