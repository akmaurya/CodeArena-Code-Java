package com.xcode.javas.pakistanuniversity;
import java.util.*;
class TimeConversion
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String result="";
		String time=sc.nextLine();
		
		if(time.charAt(8)=='P')
		{
			int h=Integer.parseInt(time.substring(0,2));
			if(h>=1&&h<12)
			h=h+12;
			result=""+h+(time.substring(2,8));
		}
		else if(time.charAt(8)=='A')
		{
			int h=Integer.parseInt(time.substring(0,2));
			if(h==12)
			{
				h=0;
				result="00"+(time.substring(2,8));
			}
			else
			result=""+(time.substring(0,8));
		}
		System.out.println(""+result);
	}
}



//
//12:40:22AM
//06:40:03
//00:40:22