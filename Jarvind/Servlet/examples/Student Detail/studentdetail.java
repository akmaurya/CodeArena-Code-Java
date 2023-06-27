import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class studentdetail extends HttpServlet
{
	String name,sex,education,address,email,password,mobile;
	int age;
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			res.setContentType("text/Html");
			PrintWriter pw=res.getWriter();
			
			name=req.getParameter("name");
			age=Integer.parseInt(req.getParameter("age"));
			sex=req.getParameter("sex");
			education=req.getParameter("edu4");
			address=req.getParameter("address");
			mobile=req.getParameter("mobile");
			email=req.getParameter("email");
			password=req.getParameter("password");
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn=DriverManager.getConnection("jdbc:odbc:School");
			Statement st=conn.createStatement();
			//st.executeUpdate("insert into Student values('"+name+"',"+age+",'"+sex+"','"+education+"','"+address+"','"+mobile+"','"+email+"','"+password+"')");
			st.executeUpdate("update Student set name='"+name+"' where email='"+email+"'");
			
			pw.println("<html><body >Successfuly Submitted<br>");
			pw.println("</body></html>");
			
			conn.close();
			pw.close();
		}
		catch(Exception e)
		{
			try
			{
				res.setContentType("text/Html");
				PrintWriter pw=res.getWriter();
				pw.println("<html><body >Sorry! This Email Is Already Registered<br>Please Try With Another Email");
				pw.println("</body></html>");
				pw.close();
			}
			catch(Exception ex)
			{
				System.out.println("Error>>>>>> In Duplicate Entry"+e);
			}
			
			System.out.println("Error>>>>>>"+e);
		}
			
		
	}
}