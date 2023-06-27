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
import javax.servlet.http.HttpSession;

import com.items.model.Client;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@SuppressWarnings("serial")
@WebServlet(name = "ClientLoginController", urlPatterns = { "/clientLogin" })
public class ClientLoginController extends HttpServlet {

	private MysqlDataSource ds = null;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		doPost(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// We can use BasicDataSource provided by drivers
		ds = new MysqlDataSource();
		ds.setURL("jdbc:mysql://localhost:3306/items");
		ds.setUser("root");
		ds.setPassword("root");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		Client client = new Client();
		client.setClientEmail(req.getParameter("InputEmail"));
		client.setClientPassword(req.getParameter("InputPassword"));
		System.out.println(client.getClientEmail());
		// ---
		
		try {
			if (isClientExists(client)) {
				Connection con = ds.getConnection();
				ResultSet rs=null;
				try {
					String sql = "select clientName, clientContact, clientEmail from client where clientEmail = ?";

					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, client.getClientEmail());
					
					
					rs=pstmt.executeQuery();
					while(rs.next()){
						client.setClientName(rs.getString("clientName"));
						client.setClientContact(rs.getString("clientContact"));
						client.setClientEmail(rs.getString("clientEmail"));
					}
					System.out.println(client.getClientName());
					
					RequestDispatcher dispatcher = req
							.getRequestDispatcher("/index.jsp");
					// Forces caches to obtain a new copy of the page from the
					// origin server
					resp.setHeader("Cache-Control", "no-cache");
					// Directs caches not to store the page under any circumstance
					resp.setHeader("Cache-Control", "no-store");
					
					// Causes the proxy cache to see the page as "stale"
					resp.setDateHeader("Expires", 0);
					// HTTP 1.0 backward compatibility
					resp.setHeader("Pragma", "no-cache");
				
					HttpSession session = req.getSession();
					session.setAttribute("client", client);
					
					dispatcher.forward(req, resp);
					
				} catch (SQLException e) {
					throw e;
				}
				/**/
			} else {
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("/index.jsp");
				// Forces caches to obtain a new copy of the page from the
				// origin server
				resp.setHeader("Cache-Control", "no-cache");
				// Directs caches not to store the page under any circumstance
				resp.setHeader("Cache-Control", "no-store");
				
				// Causes the proxy cache to see the page as "stale"
				resp.setDateHeader("Expires", 0);
				// HTTP 1.0 backward compatibility
				resp.setHeader("Pragma", "no-cache");
				
				req.setAttribute("errorMessage", "Sorry! Email ID and/or Password does not match.");
				dispatcher.forward(req, resp);
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private boolean isClientExists(Client client) throws SQLException {
		boolean clientFound = false;
		String tempClientEmail = null;
		String tempClientPassword = null;
		Connection con = null;

		try {
			con = ds.getConnection();
			ResultSet rs = null;
			String sql = "select clientEmail, clientPassword from client where clientEmail = ? and clientPassword = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, client.getClientEmail());
			pstmt.setString(2, client.getClientPassword());
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tempClientEmail = rs.getString("clientEmail");
				tempClientPassword = rs.getString("clientPassword");
			}

			if ((tempClientEmail != null && tempClientPassword !=null) && (tempClientEmail.equals(client.getClientEmail()) && tempClientPassword.equals(client.getClientPassword()))) {
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
	
}
