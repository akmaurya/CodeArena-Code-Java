package com.src.java.collection;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * This program reading from two input files. The first file is a dictionary
 * i.e. 'dictionary.dat'. The program should read the dictionary and insert the
 * words into a hash table. After reading the dictionary, it will read a list of
 * words from a second file. The goal of the spell-checker is to determine the
 * misspelled words in the second file by looking each word up in the
 * dictionary. The program should output each misspelled word.
 * 
 * @author GPS
 * 
 */
public class SpellChecker {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new File("dictionary.dat"));

		HashSet<String> dictionary = new HashSet<String>();

		while (sc.hasNext()) {
			dictionary.add(sc.next());
		}
		sc.close();

		sc = new Scanner(new File("Spellchecker.dat"));
		while (sc.hasNextLine()) {
			String[] tokens = sc.nextLine().split("\\W");
			for (String token : tokens) {
				if (token.length() > 1 && !dictionary.contains(token)) {
					System.out.println(token);
				}
			}
		}
	}
}
