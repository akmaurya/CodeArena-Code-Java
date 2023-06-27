package com.src.java.java6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class ParseXML {
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		final File file = new File(System.getProperty("user.dir")
				+ "\\src\\com\\src\\java\\resource\\Access.xml");
		InputStream input = new FileInputStream(file);
		Access access = (Access) JAXBContext.newInstance(Access.class).createUnmarshaller().unmarshal(input);
		
		System.out.println("Buyer- " + access.getBuyer().getPages());
		System.out.println("Seller- " + access.getSeller().getPages());
		System.out.println("Administrator- " + access.getAdministrator().getPages());
	}
}
