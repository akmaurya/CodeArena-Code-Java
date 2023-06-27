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
@WebServlet(name = "Servlet3", urlPatterns = { "/thirdServlet" })
public class Servlet3 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<HTML><BODY><br>Output of Servlet three<br>");

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/forthServlet");
		req.setAttribute("reqAttr1", "Object1 Coming from Previous Servlet");
		req.setAttribute("reqAttr2", "Object2 Coming from Previous Servlet");
		rd.forward(req, res);

		out.println("<br>Attribute of First Servlet:" + req.getAttribute("reqAttr1") + "<br>");
		out.println("</BODY></HTML>");
	}
}
