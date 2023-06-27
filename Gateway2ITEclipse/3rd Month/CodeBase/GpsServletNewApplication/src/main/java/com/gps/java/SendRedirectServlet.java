package com.gps.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "SendRedirectServlet", urlPatterns = { "/sendRedirectServlet" })
public class SendRedirectServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if (name.equals("James") && password.equals("abc")) {
			response.sendRedirect("http://www.google.com");
		} else {
			pw.println("u r not a valid user");
		}
	}
}
