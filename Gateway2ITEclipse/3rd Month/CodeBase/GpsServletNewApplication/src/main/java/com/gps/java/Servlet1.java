package com.gps.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//@WebServlet(name = "Servlet1", urlPatterns = { "/firstServlet" })
public class Servlet1 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<HTML><BODY><br>Output of Servlet One<br></BODY></HTML>");
		req.setAttribute("reqAttr1", "Servlet1 Request");
	}

//	@Override
//	 public void init() throws ServletException {
//		super.init(getServletConfig());
//	}
}
