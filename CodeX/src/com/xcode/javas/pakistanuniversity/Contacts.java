package com.xcode.javas.pakistanuniversity;
import java.util.*;

class Contacts
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();

		String detail[][]=new String[t][2];
		String find[]=new String[t];
		int f=0,i=0,j=0;

		sc.nextLine();

		for(i=0;i<t;i++)
		{
			detail[i][0]=sc.nextLine();
			detail[i][1]=sc.nextLine();
		}

		

		for(i=0;i<t;i++)
		{
			find[i]=sc.nextLine();
		}
			
		for(j = 0; j<t; j++)
		{
			f=0;
			for(i=0;i<t;i++)
			{
				if(find[i].equals(detail[j][0]))
				{
					System.out.println(detail[j][0]+"="+detail[j][1]);
					f=1;
					break;
				}
			}
			if(i==t&&f==0)
				System.out.println("Not found");

		}
	}
			
}




// while(in.hasNext())
//       {
//          String s=in.nextLine();
//       }