package com.src.java.modifiers.basepackage;

/**
 * base class having all types of access modifiers
 * 
 * @author GPS
 * 
 */
public class BaseClass {

	private int privateVarY = 100;
	protected int protectedVarZ = 200;
	// Implicit Default Access Modifier
	int defaultVarA = 300; 
	public int publicVarX = 400;

	public int getPublicVarX() {
		return publicVarX;
	}

	public void setPublicVarX(int x) {
		this.publicVarX = x;
	}

	protected int getProtectedVarZ() {
		return protectedVarZ;
	}

	protected void setProtectedVarZ(int z) {
		this.protectedVarZ = z;
	}

	int getDefaultVarA() {
		return defaultVarA;
	}

	void setDefaultVarA(int a) {
		this.defaultVarA = a;
	}

	@SuppressWarnings("unused")
	private int getPrivateVarY() {
		return privateVarY;
	}


	@SuppressWarnings("unused")
	private void setPrivateVarY(int y) {
		this.privateVarY = y;
	}
}