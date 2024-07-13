package com.xcode.javas.durgasoft._i_multithreading.synchronization;

public class ReadAndUpdate
{
    public static void main(String[] args) throws InterruptedException
    {
        ThreadB b = new ThreadB();
        b.start();
        //Thread.sleep(1000);
        synchronized (b){
            System.out.println("Main Thread");
            b.wait(10);
        }
        System.out.println(b.total);
    }
}

class ThreadB extends Thread{
    int total = 0;
    public void run(){
        synchronized (this)
        {
            for (int i = 1; i <= 10; i++)
            {
                total = total + i;
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            this.notify();
        }

    }

}
