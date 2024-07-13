package com.xcode.javas.durgasoft._i_multithreading;

/**
 * Created by jarvis on 4/6/17.
 */
public class SimpleThreadByRunnable
{
    public static void main(String[] args)
    {
        MyRunnable r = new  MyRunnable();
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Main Thread");
        }
    }
}

class MyRunnable implements Runnable
{
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Child Thread");
        }
    }
}
