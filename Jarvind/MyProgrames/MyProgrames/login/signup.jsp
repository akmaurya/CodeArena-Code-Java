<html>
	<body bgcolor="#eeefff">
	<%@ page import="java.sql.*"%>
	<%	
		String l1name,l2name,email,password,age,gender,mobile,location;
		l1name=request.getParameter("l1name");
		l2name=request.getParameter("l2name");
		email=request.getParameter("email");
		password=request.getParameter("password");
		age=request.getParameter("age");
		gender=request.getParameter("gender");
		mobile=request.getParameter("mobile");
		location=request.getParameter("location");

		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ=D:/Tom Cat/Tomcat 5.5/webapps/jsp-examples/MyProgrames/login/login.accdb");
		Statement st=conn.createStatement();
		
		ResultSet rs=st.executeQuery("select Email from logindetail where email='"+email+"'");
		if(rs.next())
		{%>
			<jsp:forward page="signuperror.html"/>
		<%}
		else
		{
			st.executeUpdate("insert into logindetail values('"+l1name+"','"+l2name+"','"+email+"','"+password+"','"+age+"','"+gender+"','"+mobile+"','"+location+"')");
		}

		
	conn.close();
	%>
	<jsp:forward page="loginsuccess.html"/>
	</body>
</html>