package com.src.java.string;

public class FilenameDemo {
	public static void main(String[] args) {
		// declare a String Constant
		final String FPATH = "/home/user/index.html";
		
		Filename myHomePage = new Filename(FPATH, '/', '.');
		System.out.println("Extension = " + myHomePage.extension());
		System.out.println("Filename = " + myHomePage.filename());
		System.out.println("Path = " + myHomePage.path());
	}
}
