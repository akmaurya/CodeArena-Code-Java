package com.gps.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "Servlet4", urlPatterns = { "/forthServlet" })
public class Servlet4 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<HTML><BODY><br>Output of Forth Servlet <br>");
		String str1 = (String) req.getAttribute("reqAttr1");
		String str2 = (String) req.getAttribute("reqAttr2");
		out.println("Output of previous servlet requested attribute1: " + str1);
		out.println("Output of previous servlet requested attribute2: " + str2);
		out.println("</BODY></HTML>");
	}
}
