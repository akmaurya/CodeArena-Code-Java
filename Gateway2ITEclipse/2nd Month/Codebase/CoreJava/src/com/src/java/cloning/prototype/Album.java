package com.src.java.cloning.prototype;

public class Album implements PrototypeCapable {
	private String name = null;

	Album() {
		System.out.println("Album : New Instance...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Album clone() throws CloneNotSupportedException {
		System.out.println("Cloning Album object..");
		return (Album) super.clone();
	}

	@Override
	public String toString() {
		return "Album";
	}
}
