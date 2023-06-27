package com.src.java.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to read any property file
 * 
 * @author
 * 
 */
public final class PropertyReaderUtil {

	/**
	 * Method read a property file
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static Properties readProperties(final File file) throws IOException {
		Properties properties = null;
		if (file.exists()) {
			properties = new Properties();
			FileInputStream in = new FileInputStream(file);
			properties.load(in);
		} else {
			System.out.println("File not found...");
		}

		return properties;
	}
}
