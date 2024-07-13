package com.xcode.javas.mycodeschool.datastructure.doublylinkedlist;

/**
 * Created by jarvis on 16/6/17.
 */
public class DoublyLinkedList
{
    public static void main(String[] args)
    {
        Node2 A;
        Node2 temp = new Node2();
        temp.previous = null;
        temp.data = 2;
        temp.next = null;
        A = temp;
        temp = new Node2();
        temp.previous = null;
        temp.data = 4;
        temp.next = null;
        Node2 temp1 = A;
        while (temp1.next != null)
        {
            temp1 = temp1.next;
        }
        temp.previous = temp1;
        temp1.next = temp;
        temp = new Node2();
        temp.previous = null;
        temp.data = 6;
        temp.next = null;
        temp1 = A;
        while (temp1.next != null)
        {
            temp1 = temp1.next;
        }
        temp.previous = temp1;
        temp1.next = temp;

        temp1 = A;
        while (temp1 != null)
        {
            System.out.print(temp1.data);
            if (temp1.next != null)
                System.out.print(" <-> ");
            temp1 = temp1.next;
        }
    }
}
