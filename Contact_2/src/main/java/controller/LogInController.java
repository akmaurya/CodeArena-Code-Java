package controller;


import java.io.IOException;

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


import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import model.User;

@SuppressWarnings("serial")
@WebServlet(name = "LogInController", urlPatterns = { "/LogIn" })
public class LogInController extends HttpServlet {

	

	private MysqlDataSource ds = null;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doPost(req, resp);
	}

	public void init(ServletConfig config) throws ServletException {

		// We can use BasicDataSource provided by drivers
		ds = new MysqlDataSource();
		ds.setURL("jdbc:mysql://localhost:3306/contact");
		ds.setUser("root");
		ds.setPassword("root");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		User user = new User();
		
		
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
	

		RequestDispatcher dispatcher = null;
		

		//System.out.println(req.getParameter("name"));
		System.out.println(user.getEmail());

		try {
			if (isUserExist(user)) {
				java.sql.Connection con = ds.getConnection();
				ResultSet rs=null;
				try {
					String sql = "select * from User where Email = ?";

					java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, user.getEmail());
					
					
					rs=pstmt.executeQuery();
					while(rs.next()){
						user.setName(rs.getString("Name"));
						user.setContactNo(rs.getString("ContactNo"));
						user.setEmail(rs.getString("Email"));
						user.setPassword(rs.getString("Password"));
						user.setDeleted(rs.getString("IsDeleted"));
					}
					System.out.println(user.getName());
					
					dispatcher = req
							.getRequestDispatcher("/user.jsp");
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
					session.setAttribute("User", user);
					
					dispatcher.forward(req, resp);
					
				} catch (SQLException e) {
					throw e;
				}
				/**/
			} else {
				dispatcher = req
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

	private boolean isUserExist(User user) throws SQLException {

		boolean userFound = false;
		String tempEmail = null;
		String tempPassword = null;

		java.sql.Connection con = null;

		try {
			con = ds.getConnection();
			ResultSet rs = null;
			String sql = "select Email, Password from User where Email = ? and Password = ?";
			System.out.println("Wroking1");
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			System.out.println("Wroking2");
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			System.out.println("Wroking3");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tempEmail = rs.getString("Email");
				System.out.println("Wroking4");
				tempPassword = rs.getString("Password");
				System.out.println("Wroking4.1");
			}

			if ((tempEmail != null) && (tempPassword != null) && (tempEmail.equals(user.getEmail())) && (tempPassword.equals(user.getPassword()))) {
				userFound = true;
				System.out.println("Wroking5");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return userFound;
	}
}
