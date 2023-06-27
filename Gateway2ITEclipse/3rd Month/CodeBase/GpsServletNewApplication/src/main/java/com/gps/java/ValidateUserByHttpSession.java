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
@WebServlet(name = "ValidateUserByHttpSession", urlPatterns = { "/validateUserByHttpSession" })
public class ValidateUserByHttpSession extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// These 2 parameters name must be same as given into LoginForm.html
		String userlogin = req.getParameter("userlogin");
		String userpassword = req.getParameter("userpassword");
		if (userlogin != null && userpassword != null) {
			if (UserSessionConstant.USERLOGIN.equalsIgnoreCase(userlogin)
					&& UserSessionConstant.PASSWORD.equalsIgnoreCase(userpassword)) {
				System.out.println("User Login validated successfully.....");
				HttpSession session = req.getSession();
				//HttpSession session = req.getSession(true);
				session.setAttribute(UserSessionConstant.USERLOGINATTRIBUTE, UserSessionConstant.USERLOGIN);
				res.setContentType("text/html");
				PrintWriter out = res.getWriter();
				out.println("<HTML><BODY>HELLO: "
						+ (String) session.getAttribute(UserSessionConstant.USERLOGINATTRIBUTE) + "<BR></BR>");
				out.println("<FORM NAME='UserNameForm' ACTION='/GpsServletNewApplication/validateNameByHttpSession' METHOD='POST'>");
				out.println("Name: <input type='text' name='username' />");
				out.println("<input type='submit' name='SubmitBtn' />");
				out.println("</FORM></BODY></HTML>");
				out.close();
			} else {
				System.out.println("Invalid User / Passowrd.........");
			}
		} else {
			System.out.println("Invalid User / Passowrd.........");
		}
	}
}
