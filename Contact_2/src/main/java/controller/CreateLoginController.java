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

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import model.User;

@SuppressWarnings("serial")
@WebServlet(name = "CreateLoginController", urlPatterns = { "/CreateLogin" })
public class CreateLoginController extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(CreateLoginController.class.getName());
	
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
		
		
		LOGGER.debug("CreateLoginController called...");
		
//		User user = new User();
//		ApplicationContext context = ClassPathXmlApplicationContext("SpringResources.xml");
		
		User user = new User();
		user.setName(req.getParameter("name"));
		user.setContactNo(req.getParameter("contactno"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		user.setDeleted("1");

		RequestDispatcher dispatcher = req.getRequestDispatcher("/createLogin.jsp");
		req.setAttribute("User", user);

		System.out.println(req.getParameter("name"));
		System.out.println(user.getEmail());

		try {
			if (!isUserExists(user)) {
				Connection con = (Connection) ds.getConnection();
				try {
					con.setAutoCommit(false);
					addUser(user, con);
					con.commit();
				} finally {
					if (con != null) {
						con.close();
					}
				}

				// Forces caches to obtain a new copy of the page from the
				// origin server
				resp.setHeader("Cache-Control", "no-cache");
				// Directs caches not to store the page under any circumstance
				resp.setHeader("Cache-Control", "no-store");

				// Causes the proxy cache to see the page as "stale"
				resp.setDateHeader("Expires", 0);
				// HTTP 1.0 backward compatibility
				resp.setHeader("Pragma", "no-cache");

				req.setAttribute("Message", "Successfully created your account. Please Login");
				dispatcher.forward(req, resp);

				/**/
			} else {

				// Forces caches to obtain a new copy of the page from the
				// origin server
				resp.setHeader("Cache-Control", "no-cache");
				// Directs caches not to store the page under any circumstance
				resp.setHeader("Cache-Control", "no-store");

				// Causes the proxy cache to see the page as "stale"
				resp.setDateHeader("Expires", 0);
				// HTTP 1.0 backward compatibility
				resp.setHeader("Pragma", "no-cache");

				req.setAttribute("Message", "Sorry! Email ID already exist");
				dispatcher.forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private boolean isUserExists(User user) throws SQLException {

		boolean userFound = false;
		String tempEmail = null;

		java.sql.Connection con = null;

		try {
			con = ds.getConnection();
			ResultSet rs = null;
			String sql = "select Email from User where Email = ?";

			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, user.getEmail());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				tempEmail = rs.getString("Email");
			}

			if ((tempEmail != null) && (tempEmail.equals(user.getEmail()))) {
				userFound = true;
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

	private void addUser(User user, Connection con) throws SQLException {
		try {

			String sql = "insert into User (Name, ContactNo, Email, Password, IsDeleted) values (?, ?, ?, ?, ?)";

			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getContactNo());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.isDeleted());
			pstmt.executeUpdate();
			System.out.println("User added");
		} catch (SQLException e) {
			con.rollback();
			throw e;
		}
	}
}
