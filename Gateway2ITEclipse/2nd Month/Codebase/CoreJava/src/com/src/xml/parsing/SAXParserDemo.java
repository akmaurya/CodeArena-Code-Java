package com.src.xml.parsing;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo {

	public static void main(String[] args) throws Exception {
		final File file = new File(System.getProperty("user.dir") + "\\src\\com\\src\\java\\resource\\Employee.xml");
		InputStream input = new FileInputStream(file);

		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		SAXHandler handler = new SAXHandler();
		parser.parse(input, handler);

		// Printing the list of employees obtained from XML
		for (Employee emp : handler.empList) {
			System.out.println(emp);
		}
	}
}

/**
 * The Handler for SAX Events. The SAX parser use callback function
 * (org.xml.sax.helpers.DefaultHandler) to informs clients of the XML document
 * structure.
 */

class SAXHandler extends DefaultHandler {

	List<Employee> empList = new ArrayList<>();
	Employee emp = null;
	String content = null;

	// Triggered when the start of tag is found.
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// Create a new Employee object when the start tag is found
		switch (qName) {
		case "employee":
			emp = new Employee();
			emp.setId(attributes.getValue("id"));
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		// Add the employee to list once end tag is found
		case "employee":
			empList.add(emp);
			break;
		// For all other end tags the employee has to be updated.
		case "firstName":
			emp.setFirstName(content);
			break;
		case "lastName":
			emp.setLastName(content);
			break;
		case "location":
			emp.setLocation(content);
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}
}