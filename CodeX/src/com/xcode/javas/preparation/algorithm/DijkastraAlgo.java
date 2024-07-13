package com.xcode.javas.preparation.algorithm;

import java.util.Scanner;

public class DijkastraAlgo
{
    static int count;
    static int max = 10;
    static int Non_Visited = 0;
    static int Visited = 1;
    static int[] status = new int[max];
    static int[][] cost = new int[max][max];
    static int[] dis = new int[max];
    static int n;
    static int min;
    static int k;
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the no. of vertices: ");
        n = input.nextInt();
        count=n;

        System.out.println("\nEnter the cost adjacency matrix:\n");

        for(int i=1;i<=n;i++)
        {
            //weight[i]=999;
            dis[i]=999;
            status[i]=Non_Visited;

            for(int j=1;j<=n;j++)
                cost[i][j] = input.nextInt();
            System.out.println();
        }

        dis[1]=0;

        System.out.println();
        DijkastraAlgo obj = new DijkastraAlgo();
        obj.dijkstras();
        System.out.println();
    }

    public void dijkstras()
    {
        while(count!=0)
        {
            int u=extract_min();
            status[u]=Visited;
            System.out.println(u+" [Distance:"+dis[u]+"] ");

            for(int i=1;i<=n;i++)
            {
                if(i==u)
                    continue;

                if(cost[u][i]>0)
                {
                    relax(u,i,cost[u][i]);
                }
            }

            dis[u]=999;

            count--;
        }
    }

    int extract_min()
    {
        min=dis[1];
        k=1;

        for(int i=2;i<=n;i++)
        {
            if(dis[i] < min)
            {
                min=dis[i];
                k=i;
            }
        }

        return k;
    }

    void relax(int u, int i, int w)
    {
        if(dis[i]>(dis[u]+w))
            dis[i]=(dis[u]+w);
    }
}
