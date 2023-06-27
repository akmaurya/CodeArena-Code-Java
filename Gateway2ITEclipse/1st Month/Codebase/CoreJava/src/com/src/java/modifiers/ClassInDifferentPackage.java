package com.src.java.modifiers;

import com.src.java.modifiers.basepackage.SubclassInSamePackage;

public class ClassInDifferentPackage {
	public static void main(String args[]) {
		SubclassInSamePackage subClassObjInSamePackage = new SubclassInSamePackage();

		// Access Modifiers - Public
		System.out.println("Value of x is : " + subClassObjInSamePackage.publicVarX);
		subClassObjInSamePackage.setPublicVarX(30);
		System.out.println("Value of x is : " + subClassObjInSamePackage.publicVarX);

		// Access Modifiers - Private
		// If we remove the comments it would result in a compilaton
		// error as the fields and methods being accessed are private
		// System.out.println("Value of y is : "+subClassObjInSamePackage.privateVarY);
		// subClassObjInSamePackage.setPrivateVarY(20);
		// System.out.println("Value of y is : "+subClassObjInSamePackage.privateVarY);
		 

		// Access Modifiers - Protected
		// If we remove the comments it would result in a compilaton
		// error as the fields and methods being accessed are protected.
		// System.out.println("Value of z is : "+subClassObjInSamePackage.protectedVarZ);
		// subClassObjInSamePackage.setProtectedVarZ(30);
		// System.out.println("Value of z is : "+subClassObjInSamePackage.protectedVarZ);
		 

		// Access Modifiers - Default
		// If we remove the comments it would result in a compilaton
		// error as the fields and methods being accessed are default.
		// System.out.println("Value of a is : " + subClassObjInSamePackage.defaultVarA);
		// subClassObjInSamePackage.setDefaultVarA(20);
		// System.out.println("Value of a is : " + subClassObjInSamePackage.defaultVarA);

	}
}
