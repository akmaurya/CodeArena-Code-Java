package com.items.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(name = "ClientLogoutController", urlPatterns = { "/clientLogout" })
public class ClientLogoutController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		doPost(req, resp);
	}

		public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("/index.jsp");
				// Forces caches to obtain a new copy of the page from the
				// origin server
				resp.setHeader("Cache-Control", "no-cache");
				// Directs caches not to store the page under any circumstance
				resp.setHeader("Cache-Control", "no-store");
				System.out.println("Logout Working");
				// Causes the proxy cache to see the page as "stale"
				resp.setDateHeader("Expires", 0);
				// HTTP 1.0 backward compatibility
				resp.setHeader("Pragma", "no-cache");
				HttpSession session = req.getSession();
				session.invalidate();
				
				dispatcher.forward(req, resp);
		}
}
