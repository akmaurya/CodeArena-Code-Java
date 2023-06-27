import java.io.*;
import javax.servlet.http.*;

public class simple2 extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			res.setContentType("text/Html");
			PrintWriter pw=res.getWriter();
			int n=Integer.parseInt(req.getParameter("tf"));
			pw.println("<html><body>This is table of "+n+"<br>");
			
			for(int i=1;i<=10;i++)
			pw.println((i*n)+"<br><br><br>");
			pw.println("</body></html>");
			pw.close();
		}
		catch(Exception e)
		{
			System.out.println(""+e);
		}
	}
}