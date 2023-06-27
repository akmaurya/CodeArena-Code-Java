package com.src.java.io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppendFileContent {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter the file name to create : ");
		String fileName;
		try {
			fileName = in.readLine();

			File file = new File(fileName);

			if (! file.exists()) {
				file.createNewFile();
			}
			appendContentInFile(fileName, in);
			readFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("Problem to close input stream....");
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void appendContentInFile(final String fileName, final BufferedReader in) throws IOException {
		FileWriter fWriter = new FileWriter(fileName, true);
		BufferedWriter out = new BufferedWriter(fWriter);
		out.write('\n');
		out.write(in.readLine());
		out.close();
		System.out.println("File Modified successfully.");
	}
	
	private static void readFile(final String fileName) throws IOException {
		FileReader fReader = new FileReader(fileName);
		BufferedReader out = new BufferedReader(fReader);
		String str = null;
		System.out.println("\n File Content is - ");
		while ((str = out.readLine()) != null) {			
			System.out.println(str);
		}
		out.close();
	}
}
