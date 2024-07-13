package com.xcode.javas.mycodeschool.datastructure.singlylinkedlist;

public class SinglyLinkedList
{
    public static void main(String[] args)
    {
        Node1 A;
        Node1 temp = new Node1();
        temp.data = 2;
        temp.next = null;
        A = temp;
        temp = new Node1();
        temp.data = 4;
        temp.next = null;
        Node1 temp1 = A;
        while (temp1.next != null)
        {
            temp1 = temp1.next;
        }
        temp1.next = temp;
        temp = new Node1();
        temp.data = 6;
        temp.next = null;
        temp1 = A;
        while (temp1.next != null)
        {
            temp1 = temp1.next;
        }
        temp1.next = temp;
        temp1 = A;
        while (temp1 != null)
        {
            System.out.print(temp1.data+", ");
            temp1 = temp1.next;
        }
    }
}
