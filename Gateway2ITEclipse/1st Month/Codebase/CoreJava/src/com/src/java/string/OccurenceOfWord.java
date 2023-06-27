package com.src.java.string;

/**
 * Write a program to find out number of occurrence of a word inside a String
 * paragraph
 * 
 * @author GPS
 * 
 */
public class OccurenceOfWord {
	public static void main(String[] args) {
		String paragraph = "Hello All, This is Amit from HCL. I faced lots of issue and challenges. Need to find out which one is more challenging.";
		String findStr = "is";
		
		System.out.println("No of Occurrence of [is] anywhere inside paragrapgh is: " + findOccurence(paragraph, findStr));
		System.out.println("No of Occurrence of [is] as a whole only is: " + findOccurence(paragraph, " " + findStr + " "));
	}
	
	private static int findOccurence(final String paragraph, final String findStr) {
		String splitArray[] = paragraph.split(findStr);		
		return (splitArray != null ? splitArray.length-1 : 0);
	}
}
