import java.io.*;
//import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class odbc extends HttpServlet
{
	public void doGet(HttpServletRequest req , HttpServletResponse res)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:School");
			Statement st=con.createStatement();
			st.executeUpdate("insert into Student values('NAUSHAD','AHMAD')");
			con.close();
	
		//	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//	Connection conn=DriverManager.getConnection("jdbc:odbc:School");
		//	Statement st=conn.createStatement();
		//	st.executeUpdate("insert into Student values('Vinay','MCA')");
		//	conn.close();
		}
		catch(Exception ae)
		{
			System.out.println("Sorry dear"+ae);
		}
		try
		{
			res.setContentType("text/Html");
			PrintWriter pw=res.getWriter();
			pw.println("<html><body bgcolor='green'>This is table of '9'<br>");
			int n=9;//Integer.parseInt(req.getParameter("tf"));
			for(int i=1;i<=10;i++)
			pw.println((i*n)+"<br>");
			String r=req.getParameter("tf");
			System.out.println(""+r);
			pw.println("</body></html>");
			pw.close();
			
		}
		catch(Exception e)
		{
			System.out.println("eror........"+e);
		}
		
	}
}