package com.xcode.javas.javatpoint.datastructure.linkedlist;

import java.util.Scanner;

/**
 * Created by jarvis on 3/11/16.
 */

class Node <T>
{
    public T data;
    public Node next;
}
class CompleteLinkedList <T>
{
    private Node head = null;
    public<T> void addNodeAtEnd(T data)
    {
        Node start = head;
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            while (start != null)
                start = start.next;
            start = newNode;
            head =start;
        }
        //System.out.println(start.data);
    }

    public void display()
    {
        Node start = head;
        while (start != null)
        {
            System.out.print(start.data+"   ");
            start = start.next;
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("1-Add a node at end\n2-Delete a node from last\n3-Display linked list\n4-Exit\nSelect your Choice\n\n");
            choice = input.nextInt();
            CompleteLinkedList ob = new CompleteLinkedList();
            switch (choice)
            {
                case 1:
                    String data = input.next();
                    ob.addNodeAtEnd(data);
                    break;
                case 2:
                    ob.display();
                    break;
                case 3:
                    ob.display();
                    break;
            }
        }while (choice != 4);
    }
}
