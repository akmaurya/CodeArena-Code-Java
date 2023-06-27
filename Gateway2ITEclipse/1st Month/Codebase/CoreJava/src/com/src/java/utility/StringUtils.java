package com.src.java.utility;

/**
 * String Utility class
 * 
 * @author GPS
 * 
 */
public final class StringUtils {
	/**
	 * Method return 'true' if string is empty ot null otherwsie it will return
	 * 'false'
	 * 
	 * @param sourceString
	 * @return
	 */
	public static boolean isStringEmpty(final String sourceString) {
		return (sourceString == null || sourceString.isEmpty() ? true : false);
	}
}
