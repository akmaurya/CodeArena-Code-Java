package com.src.java.modifiers.basepackage;

public class SubclassInSamePackage extends BaseClass {

	public static void main(String args[]) {

		SubclassInSamePackage subClassObjInSamePackage = new SubclassInSamePackage();
		
		subClassObjInSamePackage.overrideProtectedvariables();

		// Access Modifiers - Public
		System.out.println("Value of x is : " + subClassObjInSamePackage.publicVarX);
		subClassObjInSamePackage.setPublicVarX(20);
		System.out.println("Value of x is : " + subClassObjInSamePackage.publicVarX);

		// Access Modifiers - private
		// If we remove the comments it would result in a compilaton
		// error as the fields and methods being accessed are private
//		System.out.println("Value of y is : " + subClassObjInSamePackage.privateVarY);
//		subClassObjInSamePackage.setPrivateVarY(20);
//		System.out.println("Value of y is : " + subClassObjInSamePackage.privateVarY);

		// Access Modifiers - Protected
		System.out.println("Value of z is : " + subClassObjInSamePackage.protectedVarZ);
		subClassObjInSamePackage.setProtectedVarZ(30);
		System.out.println("Value of z is : " + subClassObjInSamePackage.protectedVarZ);

		// Access Modifiers - Default
		System.out.println("Value of A is : " + subClassObjInSamePackage.defaultVarA);
		subClassObjInSamePackage.setDefaultVarA(20);
		System.out.println("Value of A is : " + subClassObjInSamePackage.defaultVarA);
	}
	
	private void overrideProtectedvariables() {
		BaseClass baseClass = new BaseClass();
		// Override protected variable
		baseClass.protectedVarZ = 10000;
		System.out.println("Value of overriden protected z is : " + baseClass.protectedVarZ);
		System.out.println("Value of super class protected z is : " + super.protectedVarZ);
	}
}
