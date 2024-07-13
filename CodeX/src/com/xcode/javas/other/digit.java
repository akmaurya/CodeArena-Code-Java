package com.xcode.javas.other;
import java.util.*;


class digit
{
	
	public static void main(String args[])
	{
		int i,j,n,temp;
	Integer a[]=new Integer[1000];
	 Scanner in=new Scanner(System.in);

	 digit ob=new digit();


		n=in.nextInt();
		for (i=0;i<n ;i++ ) 
		{			
			a[i]=in.nextInt();
		}

		for(i=0;i<n-1;i++)
		{
			for(j=i+1;j<n;j++)
			{
				if(ob.cmp(a[i],a[j])==0)
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}

		for(i=0;i<n;i++)
		{
			System.out.print(""+a[i]);
		}
	}

	public int cmp(int a, int b)
	{

		int k1=findDigit(a),k2=findDigit(b);
		while(a>0&&b>0)
		{
			if(a/k1>b/k2)
			{
				return 1;
			}

			else if(a/k1<b/k2)
			{
				return 0;
			}

			a=a%k1;
			b=b%k2;
			k1=k1/10;
			k2=k2/10;
		}

		if(a>b)
			return 1;
		else
			return 0;
	}

	public int findDigit(int n)
	{
		int count=1;
		while(n>9)
		{
			n=n/10;
			count*=10;
		}
		return count;
	}

}