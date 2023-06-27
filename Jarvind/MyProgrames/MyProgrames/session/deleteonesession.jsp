<html>
<body>
<a href="Home.html">Home</a><br><br><br>
<%@ page import="java.util.*"%>

	<%
		String ssname=request.getParameter("ssname");
		session.removeAttribute(ssname);
	%>
	<br><br><br><br><br><center>Successfuly removed session</center>
</body>
</html>
