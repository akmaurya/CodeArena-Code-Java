<html>
<body>
<a href="Home.html">Home</a><br><br><br>
	<%
			String ssname=request.getParameter("ssname");
			String ssvalue=""+session.getAttribute(ssname);
	%>
			<center><%=ssname%> == <%=ssvalue%></center>
</body>
</html>
