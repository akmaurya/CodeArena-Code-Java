package com.src.java.java7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyPreJDK7 {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new FileReader("in.dat"));
			out = new BufferedWriter(new FileWriter("out.dat"));
			int charRead;
			while ((charRead = in.read()) != -1) {
				System.out.printf("%c ", (char) charRead);
				out.write(charRead);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally { // always close the streams
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
