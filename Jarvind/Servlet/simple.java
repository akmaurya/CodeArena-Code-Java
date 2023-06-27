import java.io.*;
import javax.servlet.http.*;

public class simple extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			res.setContentType("text/Html");
			PrintWriter pw=res.getWriter();
			pw.println("<html><body bgcolor='green'>This is table of '9'<br>");
			int n=Integer.parseInt(req.getParameter("tf"));
			for(int i=1;i<=10;i++)
			pw.println((i*n)+"<br>");
			pw.println("</body></html>");
			pw.close();
		}
		catch(Exception e)
		{
			System.out.println(""+e);
		}
	}
}