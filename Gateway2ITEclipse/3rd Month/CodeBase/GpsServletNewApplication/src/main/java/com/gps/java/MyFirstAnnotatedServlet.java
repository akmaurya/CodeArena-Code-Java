package com.gps.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "MyFirstAnnotatedServlet", urlPatterns = { "/myFirstAnnotatedServlet" })
public class MyFirstAnnotatedServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println(" <BODY bgcolor=#ADDDDA>");
		for (int i = 0; i < 20; i++) {
			out.println("<h2>_____________Hello this is first program using latest version_______</h2>");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
	}
}