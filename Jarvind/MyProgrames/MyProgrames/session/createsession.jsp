<html>
<body>
	<%
		String ssname=request.getParameter("ssname");
		String ssvalue=request.getParameter("ssvalue");

		session.setAttribute(ssname,ssvalue);
	%>
	<br><br><h2 style="color:green;">Successfuly Added</h2><br>
	<a href="Home.html">Home</a>

</body>
</html>
