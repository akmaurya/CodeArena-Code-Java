package com.xcode.javas.javatpoint.datastructure.linkedlist.single;

import java.util.Scanner;

class Node{
    public int Data;
    public Node next;
}

public class LinkedListOperations
{
    private static Node head;
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int menuChoice ;
        do{
            System.out.println("1-Insert at first");
            System.out.println("2-Insert at last");
            System.out.println("3-Insert at nth position");
            System.out.println("4-Delete from first");
            System.out.println("5-Delete from last");
            System.out.println("6-Delete nth item");
            System.out.println("7-Display list");
            System.out.println("8-Exit\n\n");
            System.out.println("Select One Linked List Operation: ");

            menuChoice = input.nextInt();
            int n,i;
            switch (menuChoice){

                case 1:
                    System.out.println("Enter Element Value:");
                    n = input.nextInt();
                    insertAtFirst(n);
                    break;
                case 2:
                    System.out.println("Enter Element Value:");
                    n = input.nextInt();
                    insertAtLast(n);
                    break;
                case 3:
                    System.out.println("Enter Element Value:");
                    n = input.nextInt();
                    System.out.println("Enter Index Value:");
                    i = input.nextInt();
                    insertAtNth(n,i);
                    break;
                case 4:
                    n = deleteFromFirst();
                    System.out.println("["+n+"] is deleted from First");
                    break;
                case 5:
                    n = deleteFromLast();
                    System.out.println("["+n+"] is deleted from Last");
                    break;
                case 6:
                    System.out.println("Enter Index Value to Delete:");
                    i = input.nextInt();
                    n = deleteNthElement(i);
                    System.out.println("["+n+"] is deleted from Last");
                    break;
                case 7:
                    System.out.println("List is :");
                    displayList();
                    break;
                case 8:
                    System.out.println("Bye.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Entry.");
            }
        }while (menuChoice!=8);
    }

    public static void insertAtFirst(int n){
        Node tempNode = new Node();
        tempNode.Data = n;
        tempNode.next = null;
        if(head==null){
            head = tempNode;
        }else {
            tempNode.next = head;
            head = tempNode;
        }
    }

    public static void insertAtLast(int n){
        Node tempNode = new Node();
        tempNode.Data = n;
        tempNode.next = null;
        if(head==null){
            head = tempNode;
        }else {
            Node tempTraverseNode = head;
            while (tempTraverseNode.next!=null){
                tempTraverseNode = tempTraverseNode.next;
            }
            tempTraverseNode.next = tempNode;
        }
    }

    public static void insertAtNth(int n, int i){
        Node tempNode = new Node();
        tempNode.Data = n;
        tempNode.next = null;
        int tempi=1;
        if(head==null && tempi!=i)
            System.out.println("Invalid Index Position");
        else {
            Node tempTraverseNode = head;
            while (tempTraverseNode!=null){
                if(i==tempi){
                    Node tempPartNode = tempTraverseNode.next;
                    tempTraverseNode.next = tempNode;
                    tempNode.next = tempPartNode;
                    break;
                }
                tempTraverseNode = tempTraverseNode.next;
                tempi++;
            }
            if (tempi<i)
                System.out.println("Invalid Index Position");
        }
    }

    public static int deleteFromFirst(){
        if (head==null){
            return -1;
        }else {
            Node tempHead = head;
            head = head.next;
            return tempHead.Data;
        }
    }

    public static int deleteFromLast(){
        if (head==null){
            return -1;
        }else {
            Node tempHead = head;
            Node tempReturnNode = null;
            while (tempHead.next!=null){
                tempReturnNode = tempHead;
                tempHead = tempHead.next;
            }

            tempReturnNode.next = null;
            return tempReturnNode.Data;
        }
    }

    public static int deleteNthElement(int i){
        int tempi=0;
        if (head==null){
            return -1;
        }else {
            Node tempHead = head;
            Node tempReturnNode = null;
            while (tempHead.next!=null){
                tempi++;
                tempHead = tempHead.next;
                if (tempi==i){
                    tempReturnNode = tempHead;
                    if(tempHead.next.next!=null)
                        tempReturnNode.next = tempHead.next.next;
                    else
                        tempReturnNode.next = null;
                    break;
                }
            }
            return tempReturnNode.Data;
        }
    }

    public static void displayList(){
        if(head==null)
            System.out.println("List is Empty");
        else
        {
            Node tempTraverseNode = head;
            while (tempTraverseNode!=null){
                System.out.print(tempTraverseNode.Data+" -> ");
                tempTraverseNode = tempTraverseNode.next;
            }
        }
        System.out.println();
    }

}
