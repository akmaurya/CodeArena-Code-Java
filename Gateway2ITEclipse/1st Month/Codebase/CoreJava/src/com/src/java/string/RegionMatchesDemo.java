package com.src.java.string;

/**
 * The program steps through the string referred to by searchMe one character at
 * a time. For each character, the program calls the regionMatches method to
 * determine whether the substring beginning with the current character matches
 * the string the program is looking for.
 * 
 * @author GPS
 * 
 */
public class RegionMatchesDemo {
	public static void main(String[] args) {
		String searchMe = "Green Eggs and Ham";
		String findMe = "Eggs";
		int searchMeLength = searchMe.length();
		int findMeLength = findMe.length();
		boolean foundIt = false;
		for (int i = 0; i <= (searchMeLength - findMeLength); i++) {
			if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
				foundIt = true;
				System.out.println("[" + searchMe.substring(i, i + findMeLength) + "] found at position [" + (i + 1)
						+ "]");
				break;
			}
		}
		if (!foundIt) {
			System.out.println("No match found.");
		}
		
		System.out.println(searchMe.indexOf(findMe) + 1);
		
		System.out.println(searchMe.indexOf(findMe) + 1);
	}
}
