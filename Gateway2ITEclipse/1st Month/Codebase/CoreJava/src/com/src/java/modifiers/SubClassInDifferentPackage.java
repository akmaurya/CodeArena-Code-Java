package com.src.java.modifiers;

import com.src.java.modifiers.basepackage.SubclassInSamePackage;

public class SubClassInDifferentPackage extends SubclassInSamePackage {

	@Override
	public int getProtectedVarZ() {
		return protectedVarZ;
	}

	public static void main(String args[]) {
		SubClassInDifferentPackage subClassDiffObj = new SubClassInDifferentPackage();

		SubclassInSamePackage subClassObjInsamePackage = new SubclassInSamePackage();

		// Access specifiers - Public
		System.out.println("Value of x is : " + subClassObjInsamePackage.publicVarX);
		subClassObjInsamePackage.setPublicVarX(30);
		System.out.println("Value of x is : " + subClassObjInsamePackage.publicVarX);

		// Access specifiers - Private
		// if we remove the comments it would result in a compilaton
		// error as the fields and methods being accessed are private
//		System.out.println("Value of y is : "+subClassObjInsamePackage.privateVarY);
//		subClassObjInsamePackage.setPrivateVarY(20);
//		System.out.println("Value of y is : "+subClassObjInsamePackage.privateVarY);
		 

		// Access specifiers - Protected
		// If we remove the comments it would result in a compilaton
		// error as the fields and methods being accessed are protected.
//		System.out.println("Value of z is : "+subClassObjInsamePackage.protectedVarZ);
//		subClassObjInsamePackage.setProtectedVarZ(30);
//		System.out.println("Value of z is : "+subClassObjInsamePackage.protectedVarZ);
		 
		System.out.println("Value of z is : " + subClassDiffObj.getProtectedVarZ());

		// Access Modifiers - Default
		// If we remove the comments it would result in a compilaton
		// error as the fields and methods being accessed are default.
//		System.out.println("Value of a is : " + subClassObjInsamePackage.defaultVarA);
//		subClassObjInsamePackage.setDefaultVarA(20);
//		System.out.println("Value of a is : " + subClassObjInsamePackage.defaultVarA);
	}
}
