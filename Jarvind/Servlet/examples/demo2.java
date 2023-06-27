import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class demo2 extends HttpServlet
{public void doGet(HttpServletRequest req,HttpServletResponse res)
	{	try
		{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn=DriverManager.getConnection("jdbc:odbc:bhu");
		Statement st=conn.createStatement();
		res.setContentType("text/HTML");
		PrintWriter pw=res.getWriter();
		int a=Integer.parseInt(req.getParameter("tf1"));
		String b=req.getParameter("tf2");
		String c=req.getParameter("tf3");
		String d=req.getParameter("tf4");

		st.executeUpdate("insert into student values("+a+",'"+b+"','"+c+"','"+d+"')");
		pw.println("<html>");
		pw.println("<body bgcolor='green'>");
		pw.println("success fully submited");
		pw.println("</body></html>");
		pw.close();
		conn.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error>>>>"+ex);
		}
	}
}