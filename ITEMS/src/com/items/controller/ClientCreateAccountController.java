package com.items.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.items.model.Client;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@SuppressWarnings("serial")
@WebServlet(name = "ClientCreateAccountController", urlPatterns = { "/clientCreateAccount" })
public class ClientCreateAccountController extends HttpServlet {

	private MysqlDataSource ds = null;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		doPost(req, resp);
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// We can use BasicDataSource provided by drivers
		ds = new MysqlDataSource();
		ds.setURL("jdbc:mysql://localhost:3306/items");
		ds.setUser("root");
		ds.setPassword("root");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		Client client = new Client();
		client.setClientName(req.getParameter("InputName"));
		client.setClientContact(req.getParameter("InputContact"));
		client.setClientEmail(req.getParameter("InputEmail"));
		client.setClientPassword(req.getParameter("InputPassword"));
		System.out.println(client.getClientName());
		System.out.println(client.getClientPassword());
		
		// ---
		try {
			if (isClientExists(client)) {
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("/index.jsp");
				// Forces caches to obtain a new copy of the page from the
				// origin server
				resp.setHeader("Cache-Control", "no-cache");
				// Directs caches not to store the page under any circumstance
				resp.setHeader("Cache-Control", "no-store");
				System.out.println("Working");
				// Causes the proxy cache to see the page as "stale"
				resp.setDateHeader("Expires", 0);
				// HTTP 1.0 backward compatibility
				resp.setHeader("Pragma", "no-cache");
				req.setAttribute("errorMessage",
						"This Email is already registered");
				dispatcher.forward(req, resp);
			} else {

				// Handling Transaction management
				Connection con = ds.getConnection();
				try {
					con.setAutoCommit(false);
					addClient(client, con);
					con.commit();
				} finally {
					if (con != null) {
						con.close();
					}
				}
				// ---
				// Database
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("/index.jsp");
				// Forces caches to obtain a new copy of the page from the
				// origin server
				resp.setHeader("Cache-Control", "no-cache");
				// Directs caches not to store the page under any circumstance
				resp.setHeader("Cache-Control", "no-store");
				System.out.println("Working");
				// Causes the proxy cache to see the page as "stale"
				resp.setDateHeader("Expires", 0);
				// HTTP 1.0 backward compatibility
				resp.setHeader("Pragma", "no-cache");
				req.setAttribute("message", null);
				req.setAttribute("successMessage",
						"You have Sucessfully Registered...");
				dispatcher.forward(req, resp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private boolean isClientExists(Client client) throws SQLException {
		boolean clientFound = false;
		String tempClientEmail = null;
		Connection con = null;

		try {
			con = ds.getConnection();
			ResultSet rs = null;
			String sql = "select clientEmail from client where clientEmail = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, client.getClientEmail());
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tempClientEmail = rs.getString("clientEmail");
			}

			if (tempClientEmail != null && tempClientEmail.equals(client.getClientEmail())) {
				clientFound = true;
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return clientFound;
	}

	private void addClient(Client client, Connection con) throws SQLException {
		try {
			String sql = "insert into client (clientName, clientContact, clientEmail, clientPassword) values (?, ?, ?, ?)";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, client.getClientName());
			pstmt.setString(2, client.getClientContact());
			pstmt.setString(3, client.getClientEmail());
			pstmt.setString(4, client.getClientPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			con.rollback();
			throw e;
		}
	}

}
