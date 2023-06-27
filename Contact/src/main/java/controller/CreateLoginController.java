package controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.User;

@SuppressWarnings("serial")
@WebServlet(name = "CreateLoginController", urlPatterns =
{ "/CreateLogin" })
public class CreateLoginController extends HttpServlet
{

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.getCurrentSession();

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringResource.xml");
		User user = (User) context.getBean("user");
		user.setName(req.getParameter("name"));
		user.setContactNo(req.getParameter("contactno"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		user.setDeleted("1");

		RequestDispatcher dispatcher = req.getRequestDispatcher("/createLogin.jsp");
		req.setAttribute("User", user);

		if (!isUserExists(user))
		{
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();

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
		} else
		{

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
	}

	private boolean isUserExists(User user)
	{

		session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", user.getEmail()));
		criteria.setProjection(Projections.rowCount());
		long count = (Long) criteria.uniqueResult();
		session.getTransaction().commit();
		if (count != 0)
			return true;
		else
			return false;
	}
}
