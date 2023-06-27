<html>
<body bgcolor="#abcdef">
<%@ page import="java.util.*"%>
	<%
		Enumeration en=session.getAttributeNames();
		while(en.hasMoreElements()==true)
		{
			String ssname=""+en.nextElement();
			session.removeAttribute(ssname);
		}
	%>
	<br><br><br><br><br><center><h3 style="color:green;">Successfuly Loged Out</h3><br><br><br>
	<h4><a href="Login.html">Login</a></h4></center>
</body>
</html>
