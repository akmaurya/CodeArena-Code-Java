package com.xcode.javas.pakistanuniversity;
import java.util.*;
class Panagram
{
	public static void main(String afr[])
	{
		String s="";
		String ans=null;
		boolean ch[]=new boolean[26];
		boolean flag=false;
		for(int i=0;i<26;i++)
		ch[i]=false;
		Scanner sc=new Scanner(System.in);
		int len=0;
		s=sc.nextLine();
		len=s.length();
		if(len<26)
			ans="not panagram";
		else
		{
			int i;
			for(i=0;i<len;i++)
			{
				char limit=s.charAt(i);
				if(limit>=65&&limit<=90)
				{
					if(ch[limit-65]==false)
						ch[limit-65]=true;
				}
				else if(limit>=97&&limit<=122)
				{
					if(ch[limit-97]==false)
						ch[limit-97]=true;
				}

			}
			for(i=0;i<26;i++)
			{
				if(ch[i]==false)
				{
					flag=true;
					ans="not panagram";
				}
			}
			if(i==26 && flag==false)
				ans="panagram";
		}
		System.out.println(ans);
	}
}