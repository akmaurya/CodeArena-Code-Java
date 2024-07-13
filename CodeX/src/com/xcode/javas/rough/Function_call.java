package com.xcode.javas.rough;

class Function_call
{
	public static void main(String s[])
	{
		int a=5,b=1;
		Function obj=new Function();
		obj.call(a,b);
	}
}

class Function
{
	Function_call ob=new Function_call();
	int c;
	void call(int a,int b)
	{
		System.out.println("Hi!");
		c=a+b;
		System.out.print("Sum="+c);
		a++;
		b++;
		String arv[]=new String[0];
		Function_call.main(arv);
	}


}