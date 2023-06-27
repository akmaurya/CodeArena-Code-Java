package com.src.java.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ValidExceptionHierarchy {
	public static void main(String[] args) {
		FileInputStream file = null;
		try {
			file = new FileInputStream("Test.java");
			file.read();
		} catch (FileNotFoundException ex) { // Not valid!
			System.out.println("File Not found in the path...");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if(file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
