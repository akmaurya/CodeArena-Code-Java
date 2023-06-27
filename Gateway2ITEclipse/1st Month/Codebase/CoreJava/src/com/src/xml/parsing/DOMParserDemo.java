package com.src.xml.parsing;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * The steps are - 1) Get a document builder using document builder factory and
 * parse the xml file to create a DOM object 2) Get a list of employee elements
 * from the DOM 3) For each employee element get the id, name, age and type.
 * Create an employee value object and add it to the list. 4) At the end iterate
 * through the list and print the employees to verify we parsed it right.
 * 
 * @author GPS
 *
 */
public class DOMParserDemo {

	public static void main(String[] args) throws Exception {

		// Get the DOM Builder Factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Get the DOM Builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Load and Parse the XML document
		// document contains the complete XML as a Tree.
		final File file = new File(System.getProperty("user.dir") + "\\src\\com\\src\\java\\resource\\Employee.xml");
		InputStream input = new FileInputStream(file);
		Document document = builder.parse(input);

		List<Employee> empList = new ArrayList<>();

		// Get the root elements & then its all children
		NodeList nodeList = document.getDocumentElement().getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {

			// We have encountered an <employee> tag.
			// get the employee element
			Node node = (Node) nodeList.item(i);

			if (node instanceof Element) {
				Employee emp = new Employee();
				emp.setId(node.getAttributes().getNamedItem("id").getNodeValue());
				NodeList childNodes = node.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++) {
					Node cNode = (Node) childNodes.item(j);

					// Identifying the child tag of employee encountered.
					if (cNode instanceof Element) {
						String content = cNode.getLastChild().getTextContent().trim();

						switch (cNode.getNodeName()) {
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
				}
				empList.add(emp);
			}
		}

		// Printing the Employee list populated.
		for (Employee emp : empList) {
			System.out.println(emp);
		}
	}
}
