package com.xcode.javas.durgasoft._i_multithreading;

/**
 * Created by jarvis on 4/6/17.
 */
public class GettinAndSettingThreadName
{
    public static void main(String[] args)
    {
        System.out.println(Thread.currentThread().getName());
        Test t = new Test();
        System.out.println(t.getName());
        Thread.currentThread().setName("Pawan");
        System.out.println(Thread.currentThread().getName());
    }
}
class Test extends Thread
{

}
