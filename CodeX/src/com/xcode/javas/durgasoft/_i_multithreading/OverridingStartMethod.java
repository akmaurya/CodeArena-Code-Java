package com.xcode.javas.durgasoft._i_multithreading;

/**
 * Created by jarvis on 4/6/17.
 */
public class OverridingStartMethod
{
    public static void main(String[] args)
    {
        MyThread1 t = new MyThread1();
        t.start();
        System.out.println("This is main method");
        //t.start(); //we can not restart a thread
    }
}

class MyThread1 extends Thread
{
    public void start()
    {
        //super.start();
        System.out.println("This is start method");
    }

    public void run()
    {
        System.out.println("This is run method");
    }
}