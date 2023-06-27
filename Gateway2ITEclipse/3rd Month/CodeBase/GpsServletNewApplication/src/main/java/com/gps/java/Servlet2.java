package com.gps.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "Servlet2", urlPatterns = { "/secondServlet" })
public class Servlet2 extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<HTML><BODY><br>Output of Servlet Two<br>");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/firstServlet");
		rd.include(req, res);
		out.println("<br>Attribute of First Servlet:" + req.getAttribute("reqAttr1")+"<br>");
		out.println("</BODY></HTML>");
	}
}

