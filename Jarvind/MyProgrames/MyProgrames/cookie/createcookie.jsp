<html>
<body>
	<%
		String ckname=request.getParameter("ckname");
		String ckvalue=request.getParameter("ckvalue");

		Cookie ck=new Cookie(ckname,ckvalue);
		response.addCookie(ck);
	%>
	<br><br><h2 style="color:green;">Successfuly Created</h2><br>
	<a href="Home.html">Home</a>

</body>
</html>
