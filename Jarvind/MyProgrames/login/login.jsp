<html>
	<body bgcolor="#eeefff">
	<%@ page import="java.sql.*"%>
	
	<%	
		String l1name="",l2name="",email="",password="",age="",gender="",mobile="",location="";
		String email1="",password1="";
		email1=request.getParameter("email");
		password1=request.getParameter("password");
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ=D:/Tom Cat/Tomcat 5.5/webapps/jsp-examples/MyProgrames/login/login.accdb");
		Statement st=conn.createStatement();
		ResultSet rs;
		rs=st.executeQuery("select * from logindetail where Email='"+email1+"' and Password='"+password1+"'");
		if(rs.next())
		{
			
			l1name=rs.getString(1);
			l2name=rs.getString(2);
			email=rs.getString(3);
			password=rs.getString(4);
			age=rs.getString(5);
			gender=rs.getString(6);
			mobile=rs.getString(7);
			location=rs.getString(8);
			if(email1.equals(email)&&password1.equals(password))
			{
	%>			<h5 style="color:green">Welcome <%=l1name%> <%=l2name%></body></h5><br><br><br><br><br>
				Name: <%=l1name%> <%=l2name%><br>
				Email: <%=email%><br>
				Mobile: <%=mobile%><br>
				Location: <%=location%>
				
			<%}
			else
			{%>
				<jsp:forward page="loginerror.html"/>
			<%}
		}
		else
		{%>
			<jsp:forward page="loginerror.html"/>
		<%}
		conn.close();
		%>
	</body>
</html>