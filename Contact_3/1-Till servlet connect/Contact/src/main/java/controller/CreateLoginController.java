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

import model.User;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


@SuppressWarnings("serial")
@WebServlet(name = "CreateLoginController", urlPatterns = { "/CreateLogin" })
public class CreateLoginController extends HttpServlet{
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	
			throws IOException, ServletException {
		doPost(req, resp);
	}

	public void init(ServletConfig config) throws ServletException {
		
		// We can use BasicDataSource provided by drivers
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		MysqlDataSource ds=  new MysqlDataSource();
		ds.setUser("root");
		ds.setPassword("root");
		ds.setServerName("localhost:3306");
		ds.setDatabaseName("contact");
		
		
		
		
		
		/*ds.setURL("jdbc:mysql://localhost:3306/contact");
		ds.setUser("root");
		ds.setPassword("root");*/
				System.out.println(req.getParameter("name"));
	}
}
