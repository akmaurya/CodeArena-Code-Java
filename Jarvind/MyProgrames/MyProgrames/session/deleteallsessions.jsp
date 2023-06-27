<html>
<body>
<a href="Home.html">Home</a><br><br><br>
<%@ page import="java.util.*"%>
	<%
		Enumeration en=session.getAttributeNames();
		while(en.hasMoreElements()==true)
		{
			String ssname=""+en.nextElement();
			session.removeAttribute(ssname);
		}
	%>
	<br><br><br><br><br><center>Successfuly removed all sessions</center>
</body>
</html>
