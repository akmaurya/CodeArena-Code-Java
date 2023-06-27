package controller;


import java.io.IOException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.User;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;



@SuppressWarnings("serial")
@WebServlet(name = "AddContactController", urlPatterns = { "/AddContact" })
public class AddContactController extends HttpServlet {


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
		
		
		System.out.println(req.getParameter("name"));
		User user = (User)req.getSession().getAttribute("User");
		System.out.println(user.getEmail());
		
		
		
	}
}
