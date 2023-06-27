package com.mainClass;

public class SecondClass {

	ThirdClass thirdClass;

	public void funcFirst() {

		System.out.println("func First is working...");

		thirdClass.funcThirdFirst();
	}

	public ThirdClass getThirdClass() {
		return thirdClass;
	}

	public void setThirdClass(ThirdClass thirdClass) {
		this.thirdClass = thirdClass;
	}

}
