package com.src.java.java7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyJDK7 {
	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(new FileReader("in.dat"));
				BufferedWriter out = new BufferedWriter(new FileWriter("newout.dat"))) {
			int charRead;
			while ((charRead = in.read()) != -1) {
				System.out.printf("%c ", (char) charRead);
				out.write(charRead);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
