package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
abstract class Book
{
    String title;
    String author;
    Book(String t,String a){
        title=t;
        author=a;
    }
    abstract void display();
}

class MyBook extends Book
{
    private int price;
    MyBook(String title, String author, int price)
    {
        super(title, author);
        this.price = price;
    }
    @Override
    void display()
    {
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: "+price);
    }
}

class Day13AbstractClass
{
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        String title=sc.nextLine();
        String author=sc.nextLine();
        int price=sc.nextInt();
        Book new_novel=new MyBook(title,author,price);
        new_novel.display();

    }
}


        /*
            Sample Input

            The following input from stdin is handled by the locked stub code in your editor:

            The Alchemist
            Paulo Coelho
            248
            Sample Output

            The following output is printed by your display() method:

            Title: The Alchemist
            Author: Paulo Coelho
            Price: 248
        */