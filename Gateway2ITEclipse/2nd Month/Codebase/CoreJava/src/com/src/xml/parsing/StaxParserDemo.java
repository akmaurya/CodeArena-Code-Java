package com.src.xml.parsing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxParserDemo {

	public static void main(String[] args) throws XMLStreamException, FileNotFoundException {

		final File file = new File(System.getProperty("user.dir")
				+ "\\src\\com\\src\\java\\resource\\Employee.xml");
		InputStream input = new FileInputStream(file);
		
		List<Employee> empList = null;
		Employee currEmp = null;
		String tagContent = null;
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(input);

		while (reader.hasNext()) {
			int event = reader.next();
			switch (event) {
			case XMLStreamConstants.START_ELEMENT:
				if ("employee".equals(reader.getLocalName())) {
					currEmp = new Employee();
					currEmp.setId(reader.getAttributeValue(0));
				}
				if ("employees".equals(reader.getLocalName())) {
					empList = new ArrayList<>();
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				tagContent = reader.getText().trim();
				break;
			case XMLStreamConstants.END_ELEMENT:
				switch (reader.getLocalName()) {
				case "employee":
					empList.add(currEmp);
					break;
				case "firstName":
					currEmp.setFirstName(tagContent);
					break;
				case "lastName":
					currEmp.setLastName(tagContent);
					break;
				case "location":
					currEmp.setLocation(tagContent);
					break;
				}
				break;
			case XMLStreamConstants.START_DOCUMENT:
				empList = new ArrayList<>();
				break;
			}
		}

		// Print the employee list populated from XML
		for (Employee emp : empList) {
			System.out.println(emp);
		}
	}
}