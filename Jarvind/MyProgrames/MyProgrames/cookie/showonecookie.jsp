<html>
<body>
<a href="Home.html">Home</a><br><br>
<a href="showonecookie.html">Back</a><br><br>
	
	<%
		String ckname=request.getParameter("ckname");
		int i=0;
		Cookie ck[]=request.getCookies();
		if(ck!=null)
		{
			for(i=0;i<ck.length;i++)
			{
				if(ckname.equals(ck[i].getName()))
				{
					String ckvalue=ck[i].getValue();
			%>
					<center>
					<br><br><br><br><br>
					Cookie Name= <%=ckname%><br>
					Value= <%=ckvalue%>		
					</center>
			<%
					break;
				}
			}
			if(i>=ck.length)
			{
			%>
				<center><br><br><br><br><br><br><br><br>
					Sorry No Such Name of Cookie Is Find1
				</center>
			<%
			}
		}
		else
		{
		%>
			<center><br><br><br><br><br><br><br><br>
				Sorry No Such Name of Cookie Is Find2
			</center>
		<%
		}
	%>
</body>
</html>
