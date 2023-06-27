package com.gps.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "DisplayFactorial1", urlPatterns = { "/findFactorial1" }, initParams = { @WebInitParam(name = "defaultVal", value = "7") })
public class DisplayFactorial1 extends HttpServlet {
	String iNumber = "";

	@Override
	public void init() {
		ServletConfig config = getServletConfig();
		iNumber = config.getInitParameter("defaultVal");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String num = req.getParameter("num");

		if (num == null || num.trim().length() == 0) {
			num = iNumber;
		}

		int n = Integer.parseInt(num);
		int sum = 1;
		for (int i = 1; i <= n; i++) {
			sum = sum * i;
		}
		out.println("<HTML>");
		out.println(" <BODY bgcolor=#ADDDDA>");
		out.println("<h2>______Factoria  of _" + n + " is " + sum + "__</h2>");
		out.println("  </BODY>");
		out.println("</HTML>");
	}
}
