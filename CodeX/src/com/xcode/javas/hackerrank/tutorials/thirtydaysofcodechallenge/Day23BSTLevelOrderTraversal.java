package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 24/10/16.
 */

class Node2{
    Node2 left,right;
    int data;
    Node2(int data){
        this.data=data;
        left=right=null;
    }
}

class Day23BSTLevelOrderTraversal
{

    static Node2 Queue[] = new Node2[100];
    static int front = -1;
    static int rear = 0;

    static void levelOrder(Node2 root)
    {
        //Write your code here
        if(root != null)
            Queue[++front] = root;
        while (root != null)
        {
            System.out.print(Queue[rear].data+" ");
            if (Queue[rear].left != null)
                Queue[++front] = Queue[rear].left;
            if (Queue[rear].right != null)
                Queue[++front] = Queue[rear].right;
            rear++;
        }
    }

    public static Node2 insert(Node2 root,int data){
        if(root==null){
            return new Node2(data);
        }
        else{
            Node2 cur;
            if(data<=root.data)
            {
                cur=insert(root.left,data);
                root.left=cur;
            }
            else
            {
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node2 root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }
}


        /*
            Sample Input

            6
            3
            5
            4
            7
            2
            1
            Sample Output

            3 2 5 1 4 7
        */