package com.xcode.javas.pakistanuniversity;
import java.util.*;

//	e	a	k	o	u 	r	
//	0	1	2	3	4	5
//	5	4	3	2	1	0

class FunnyString
{
	public static void main(String args[])
	{
		String ans="";
		int n=0;

		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		String S[]=new String[n+1];

		for(int i=0;i<=n;i++)
		{
			S[i]=sc.nextLine();
		}

		for(int t=1;t<=n;t++)
		{
			int i=0,j=0,si_i1=0,ri_i1=0,flag=1;
			
			int len=S[t].length();
			for(i=1,j=(len-2);i<len;i++,j--)
			{
				si_i1=Math.abs((int)S[t].charAt(i)-(int)S[t].charAt(i-1));
				ri_i1=Math.abs((int)S[t].charAt(j)-(int)S[t].charAt(j+1));
				if(si_i1!=ri_i1)
				{
					flag=0;
					ans="Not Funny";
				}
			}

			if(flag==1)
				ans="Funny";
			System.out.println(""+ans);
		}
		
	}
}