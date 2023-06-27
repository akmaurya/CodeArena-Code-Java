package com.gps.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gps.util.UserSessionConstant;

@SuppressWarnings("serial")
@WebServlet(name = "ValidateAgeByHttpSession", urlPatterns = { "/validateAgeByHttpSession" })
public class ValidateAgeByHttpSession extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			String userlogin = (String) session.getAttribute(UserSessionConstant.USERLOGINATTRIBUTE);
			if (userlogin.equalsIgnoreCase(UserSessionConstant.USERLOGIN)) {
				System.out.println("User Session exist for " + userlogin);
				int userage = Integer.parseInt(req.getParameter("userage"));
				if (userage == UserSessionConstant.USERAGE) {
					System.out.println("Userage matching successfully....");

					res.setContentType("text/html");
					PrintWriter out = res.getWriter();
					out.println("<HTML><BODY>HELLO: "
							+ (String) session.getAttribute(UserSessionConstant.USERLOGINATTRIBUTE)
							+ ". You are Loggen in. <BR></BR>");
					out.println("</BODY></HTML>");
					//session.invalidate();
				} else {
					System.out.println("Userage " + userage + " does not matching.");
				}
			} else {
				System.out.println("Invalid User....");
			}
		} else {
			System.out.println("Session has expired....");
		}
	}
}
