<html>
<body>
<a href="Home.html">Home</a><br><br>
	
	<%
		String ckname,ckvalue;
		Cookie ck[]=request.getCookies();
		if(ck!=null)
		{
			for(int i=0;i<ck.length;i++)
			{
				ckname=ck[i].getName();
				ckvalue=ck[i].getValue();
			%>
				<%=ckname%> - <%=ckvalue%>
				<br>
			<%
			}
		}
	%>
</body>
</html>
