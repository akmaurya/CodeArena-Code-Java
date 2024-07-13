package com.xcode.javas.rough.oracle;

/**
 * Created by jarvis on 1/1/17.
 */
public class LambdaExample_1
{
    public static void main(String[] args) {
             System.out.println("=== RunnableTest ===");


             // Anonymous Runnable
             Runnable r1 = new Runnable(){

               @Override
       public void run(){
                         System.out.println("Hello world one!");
                       }
     };

             // Lambda Runnable
             Runnable r2 = () -> System.out.println("Hello world two!");

             // Run em!
             r1.run();
             r2.run();

           }
 }