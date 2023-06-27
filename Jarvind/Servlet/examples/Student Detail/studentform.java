import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class studentform extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		/*try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn=DriverManager.getConnection("jdbc:odbc:School");
			Statement st=conn.createStatement();
			st.executeUpdate("insert into Student values('Vinay','MCA')");
			conn.close();
		}*/
		
		try
		{
			Class.forName("sun.jdbc.odbc.JbdcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:School");
			Statement st=con.createStatement();
			st.executeUpdate("insert into EMP values('NAUSHAD','AHMAD')");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error in Connection"+e);
		}
		try
		{			
			res.setContentType("text/Html");
			PrintWriter pw=res.getWriter();
			pw.println("<html><body bgcolor='green'>This is table of '9'<br>");
			int n=9;//Integer.parseInt(req.getParameter("tf"));
			for(int i=1;i<=10;i++)
			pw.println((i*n)+"<br>");
			pw.println("</body></html>");
			pw.close();
			
		}
		catch(Exception e)
		{
			System.out.println("eror........"+e);
		}
	}
}