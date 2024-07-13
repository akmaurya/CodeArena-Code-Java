package com.xcode.javas.mycodeschool.datastructure.singlylinkedlist;

import java.util.Scanner;

/**
 * Created by jarvis on 15/6/17.
 */
public class PrintAndReversePrintByRecursive
{
    public static Node1 Head;
    public static void main(String[] args)
    {
        Head = null;
        PrintAndReversePrintByRecursive ob = new PrintAndReversePrintByRecursive();
        System.out.println("How many Numbers :- ");
        Scanner input = new Scanner(System.in);
        int n =input.nextInt();
        for (int i = 0; i < n; i++)
        {
            System.out.print("\nEnter "+(i+1)+" Number :-");
            int x = input.nextInt();
            ob.insert(x);

        }
        System.out.println("Simple Print");
        ob.printRecursive(Head);
        System.out.println("\nReverse Print");
        ob.reversePrintRecursive(Head);
    }

    public void insert(int x)
    {
        Node1 temp = new Node1();
        temp.data = x;
        temp.next = Head;
        Head = temp;

    }

    public void printRecursive(Node1 P)
    {
        if (P == null)
            return;
        System.out.print(P.data);
        if (P.next != null)
            System.out.print(" -> ");
        printRecursive(P.next);
    }

    public void reversePrintRecursive(Node1 P)
    {
        if (P == null)
            return;
        reversePrintRecursive(P.next);
        System.out.print(P.data);
        if (P != Head)
            System.out.print(" -> ");
    }
}