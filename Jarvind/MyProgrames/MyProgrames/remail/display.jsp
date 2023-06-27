<html>
	<body>
		
	<%@ page import="java.sql.*"%>
	<%
		String subj=request.getParameter("subj");
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ=D:/Tom Cat/Tomcat 5.5/webapps/jsp-examples/MyProgrames/remail/inbox.accdb");
		String subject=request.getParameter("")
	%>
	</body>
</html>