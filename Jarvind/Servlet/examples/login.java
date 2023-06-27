import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class login extends HttpServlet
{
	String email,password,name,sex,education,address,mobile,age;
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			res.setContentType("text/Html");
			PrintWriter pw=res.getWriter();
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn=DriverManager.getConnection("jdbc:odbc:School");
			Statement st=conn.createStatement();
			
			
			email=req.getParameter("email");
			password=req.getParameter("password");
			
			ResultSet rs=st.executeQuery("select * from Student where email='"+email+"' and password='"+password+"'");
			if(rs.next()==true)
			{
				name=rs.getString(1);
				age=rs.getString(2);
				sex=rs.getString(3);
				education=rs.getString(4);
				address=rs.getString(5);
				mobile=rs.getString(6);
				
				pw.println("<html><title>Sign Up Form</title><body bgcolor='#eeeeff'><form method='get' action='http://127.0.0.1:8080/servlet/login'><br><br>");
				pw.println("                  Email          <input type='text' name='email' value='"+email+"'><br><br>");
				pw.println("                  Password    <input type='password' name='password'><br><br>");
				pw.println("                    <input type='submit' name='submit' value='Login'>");
				pw.println("                    <input type='reset' name='reset' value='Reset'>");
				pw.println("<br><br>Your Record Found<br>");
				pw.println("<hr></hr>Name    "+name+"<br><hr></hr>");
				pw.println("Age       "+age+"<br>");
				pw.println("Sex       "+sex+"<br><hr></hr>");
				pw.println("Education       "+education+"<br><hr></hr>");
				pw.println("Address       "+address+"<br>");
				pw.println("Mobile No.    "+mobile+"<br><br><hr></hr>");
				pw.println("<a href='#top'>Top</a>");
				pw.println("</form></body></html>");
			}
			else
			{
				pw.println("<html><body><form method='get' action='http://127.0.0.1:8080/servlet/login'><br><br>");
				pw.println("                  Email          <input type='text' name='email' value='"+email+"'><br><br>");
				pw.println("                  Password    <input type='password' name='password'><br><br>");
				pw.println("                    <input type='submit' name='submit' value='Login'>");
				pw.println("                    <input type='reset' name='reset' value='Reset'>");
				pw.println("                    <br><hr></hr><br>Sorry You Have Not Signed Up/Worng email or password");
				pw.println("</form></body></html>");
			}
			pw.close();
		}
		catch(Exception e)
		{
			System.out.println(""+e);
		}
	}
}