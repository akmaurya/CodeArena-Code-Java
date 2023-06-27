package com.gps.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gps.util.UserSessionConstant;

@SuppressWarnings("serial")
@WebServlet(name = "ValidateNameByCookies", urlPatterns = { "/validateNameByCookies" })
public class ValidateNameByCookies extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(ValidateNameByCookies.class);

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		Cookie cookies[] = req.getCookies();
		String userlogin = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String cookiename = cookie.getName();
				System.out.println(cookiename);
				if (cookiename.equalsIgnoreCase(UserSessionConstant.USERLOGINATTRIBUTE)) {
					userlogin = cookie.getValue();
				}
			}
			if (userlogin != null && userlogin.equalsIgnoreCase(UserSessionConstant.USERLOGIN)) {
				LOGGER.debug("User Session exist for " + userlogin);
				String username = req.getParameter("username");
				if (username != null && username.trim().equalsIgnoreCase(UserSessionConstant.USERNAME)) {
					LOGGER.debug("Username matching successfully....");
					res.setContentType("text/html");
					PrintWriter out = res.getWriter();
					out.println("<HTML><BODY>HELLO: " + userlogin + ". You are Loggen in. <BR></BR>");
					out.println("<FORM NAME='UserAgeForm' ACTION='/GpsServletNewApplication/validateAgeByCookies' METHOD='POST'>");
					out.println("Age: <input type='text' name='userage' />");
					out.println("<input type='submit' name='SubmitBtn' />");
					out.println("</FORM></BODY></HTML>");
				} else {
					LOGGER.debug("Username " + username + " does not matching.");
				}
			} else {
				LOGGER.debug("Invalid User....");
			}
		} else {
			LOGGER.debug("Session has expired....");
		}
	}
}
