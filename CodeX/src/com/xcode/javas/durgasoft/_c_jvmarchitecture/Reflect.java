package com.xcode.javas.durgasoft._c_jvmarchitecture;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Reflect
{
	public static void main(String ar[]) throws Exception
	{
		int count=0;

		Class c= Class.forName("java.util.stream.Stream");
		System.out.println("Class Name : "+c.getName());
		Method[] m=c.getDeclaredMethods();
		Field[] f=c.getDeclaredFields();
		System.out.println("Methods : ");
		for(Method m1:m)
		{
			count++;
			System.out.println(count+" - "+m1.getName());
		}
		System.out.println("Total methods of Class class = "+count);
		count=0;
		System.out.println("Fields : ");
		for(Field f1:f)
		{
			count++;
			System.out.println(count+" - "+f1.getName());
		}
		System.out.println("Total fields of "+c.getName()+" class = "+count);
	}
}