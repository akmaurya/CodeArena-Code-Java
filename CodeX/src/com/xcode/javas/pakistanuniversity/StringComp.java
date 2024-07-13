package com.xcode.javas.pakistanuniversity;
class StringComp
{
	public static void main(String args[])
	{
		String s1=new String("India");
		String s2="India";
		if(s1==s2)
		System.out.println("Equal with ==");
		if(s1.equals(s2))
		System.out.println("Equal using equals");
	}
}