<html>
<body>
<a href="Home.html">Home</a><br><br><br>
<%@ page import="java.util.*"%>
	<%
		Enumeration en=session.getAttributeNames();
		while(en.hasMoreElements()==true)
		{
			String ssname=""+en.nextElement();
			String ssvalue=""+session.getAttribute(ssname);
	%>
			<%=ssname%> == <%=ssvalue%><br>
	<%
		}
	%>
	
	

</body>
</html>
