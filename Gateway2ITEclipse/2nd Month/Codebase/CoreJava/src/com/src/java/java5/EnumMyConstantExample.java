package com.src.java.java5;

public class EnumMyConstantExample {
	public static void main(String[] args) {

		String str1 = MyConstants.TEMP1.getStrVal();
		String str2 = MyConstants.TEMP2.getStrVal();
		int i = MyConstants.TEMP3.getiVal();

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(i);
		
		for(MyConstants constant : MyConstants.values()) {
			System.out.println(constant.getStrVal());
		}
	}
}
