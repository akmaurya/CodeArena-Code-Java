package com.mainClass;

public class SecondClass {

	ThirdClass thirdClass;
	
	
	public SecondClass(ThirdClass thirdClass,String abc) {
		super();
		this.thirdClass = thirdClass;
		
		System.out.println(abc);
	}






	public void funcFirst() {

		System.out.println("func First is working...");

		thirdClass.funcThirdFirst();
	}



}
