package com.gps.java;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "DisplayContextParam", urlPatterns = { "/printContext" })
public class DisplayContextParam extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		
		ServletContext context = getServletContext();
		String admin = context.getInitParameter("AdminUser");
		String password = context.getInitParameter("AdminPassword");
		System.out.println("Admin User: " + admin + "      Password: " + password);
		
		context.setAttribute("AnyObject", "We can Store any Object inside the context as an Attribute.");
		String contextAttr = (String) context.getAttribute("AnyObject");
		System.out.println("Value of Context Attribute (AnyObject): " + contextAttr);
		
		context.setAttribute("AnyObject", "Attribute value can be changed any where within web application");
		contextAttr = (String) context.getAttribute("AnyObject");
		System.out.println("Changed Value of Context Attribute (AnyObject): " + contextAttr);
		
		context.log("Log the messages into the Log File…");
	}
}
