import java.io.*;
import javax.servlet.http.*;

public class studentform extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			res.setContentType("text/Html");
			PrintWriter pw=res.getWriter();
			pw.println("<html><body><form method='get'action='http://127.0.0.1:8080/servlet/login>'");
			pw.println("                  Email  <input type='text' name='email'><br><br>");
			pw.println("                    Password  <input type='password' name='password'><br><br>");
			pw.println("                    <input type='submit' name='submit' value='Login'>");
			pw.println("                    <input type='reset' name='reset' value='Reset'>");
			pw.println("</body></html>");
			pw.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(""+e);
		}
	}
}