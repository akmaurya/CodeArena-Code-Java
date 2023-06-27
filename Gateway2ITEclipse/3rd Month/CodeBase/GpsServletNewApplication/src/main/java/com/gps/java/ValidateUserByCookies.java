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
@WebServlet(name = "ValidateUserByCookies", urlPatterns = { "/validateUserByCookies" })
public class ValidateUserByCookies extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(ValidateUserByCookies.class);
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// These 2 parameters name must be same as given into LoginForm1.html
		String userlogin = req.getParameter("userlogin");
		String userpassword = req.getParameter("userpassword");
		if (userlogin != null && userpassword != null) {
			if (UserSessionConstant.USERLOGIN.equalsIgnoreCase(userlogin)
					&& UserSessionConstant.PASSWORD.equalsIgnoreCase(userpassword)) {
				LOGGER.debug("User Login validated successfully.....");
				Cookie cookies[] = req.getCookies();
				Cookie cookie = null;
				if (cookies == null) {
					cookie = new Cookie(UserSessionConstant.USERLOGINATTRIBUTE, UserSessionConstant.USERLOGIN);
					res.addCookie(cookie);
				} else {
					cookie = new Cookie(UserSessionConstant.USERLOGINATTRIBUTE, UserSessionConstant.USERLOGIN);
					res.addCookie(cookie);
					for(Cookie cook: cookies) {
						System.out.println(cook.getName() + "----" + cook.getValue());
					}
//					if(cookies.length == 1) {
//						if(! cookies[0].getName().equalsIgnoreCase(UserSessionConstant.USERLOGINATTRIBUTE)) {
//							cookie = new Cookie(UserSessionConstant.USERLOGINATTRIBUTE, UserSessionConstant.USERLOGIN);
//							res.addCookie(cookie);
//						}						
//					}
				}
				res.setContentType("text/html");
				PrintWriter out = res.getWriter();
				out.println("<HTML><BODY><BR></BR>");
				out.println("<FORM NAME='UserNameForm' ACTION='/GpsServletNewApplication/validateNameByCookies' METHOD='POST'>");
				out.println("Name: <input type='text' name='username' />");
				out.println("<input type='submit' name='SubmitBtn' />");
				out.println("</FORM></BODY></HTML>");
				out.close();
			} else {
				LOGGER.debug("Invalid User / Passowrd.........");
			}
		} else {
			LOGGER.debug("Invalid User / Passowrd.........");
		}
	}
}
