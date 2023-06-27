package com.src.java.io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class ReadAndWriteUTFEncoding {
	public static void main(String[] args) {
		File filename = new File("utf8encoding.txt");

		utfWriter(filename);
		System.out.println("File successfully created...");
		System.out.println("File Content is - ");
		utfReader(filename);
	}

	private static void utfWriter(final File filename) {
		try {
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF8"));

			out.append("Website UTF-8").append("\r\n");
			out.append("䦦コめ じぢゃ蝥㠧簥 䩩騧ほ堨べ び楌奯狦ぐ ぎょき").append("\r\n");

			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void utfReader(final File filename) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF8"));

			String str;
			while ((str = in.readLine()) != null) {
				System.out.println(str);
			}
			in.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
