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
@WebServlet(name = "ValidateNameByHttpSession", urlPatterns = { "/validateNameByHttpSession" })
public class ValidateNameByHttpSession extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			String userlogin = (String) session.getAttribute(UserSessionConstant.USERLOGINATTRIBUTE);
			if (userlogin.equalsIgnoreCase(UserSessionConstant.USERLOGIN)) {
				System.out.println("User Session exist for " + userlogin);
				String username = req.getParameter("username");
				if (username != null && username.trim().equalsIgnoreCase(UserSessionConstant.USERNAME)) {
					System.out.println("Username matching successfully....");
					res.setContentType("text/html");
					PrintWriter out = res.getWriter();
					out.println("<HTML><BODY>HELLO: "
							+ (String) session.getAttribute(UserSessionConstant.USERLOGINATTRIBUTE)
							+ ". You are Loggen in. <BR></BR>");
					out.println("<FORM NAME='UserAgeForm' ACTION='/GpsServletNewApplication/validateAgeByHttpSession' METHOD='POST'>");
					out.println("Age: <input type='text' name='userage' />");
					out.println("<input type='submit' name='SubmitBtn' />");
					out.println("</FORM></BODY></HTML>");
				} else {
					System.out.println("Username " + username + " does not matching.");
				}
			} else {
				System.out.println("Invalid User....");
			}
		} else {
			System.out.println("Session has expired....");
		}
	}
}
