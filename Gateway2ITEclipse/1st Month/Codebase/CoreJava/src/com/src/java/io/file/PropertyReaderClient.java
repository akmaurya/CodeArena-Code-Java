package com.src.java.io.file;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderClient {

	private static final File file = new File(System.getProperty("user.dir")
			+ "\\src\\com\\src\\java\\resource\\Application.properties");

	public static void main(String[] args) throws IOException {

		Properties properties = PropertyReaderUtil.readProperties(file);

		System.out.println("Properties are : ");
		System.out.println(properties.get("db.name"));
		System.out.println(properties.get("db.type"));
		System.out.println(properties.get("db.version"));
		System.out.println(properties.get("db.class"));
		System.out.println(properties.get("db.path"));
		System.out.println(properties.get("connection.url"));
	}
}
