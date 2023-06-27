<%@ page import="java.sql.*"%>
<%
	String to,subject,message;
	to=request.getParameter("to");
	subject=request.getParameter("subject");
	message=request.getParameter("message");

	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection conn1=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ=D:/Tom Cat/Tomcat 5.5/webapps/jsp-examples/MyProgrames/remail/remail.accdb");
	Connection conn2=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ=D:/Tom Cat/Tomcat 5.5/webapps/jsp-examples/MyProgrames/remail/inbox.accdb");
	Statement st1=conn1.createStatement();
	Statement st2=conn2.createStatement();
	ResultSet rs=st1.executeQuery("select email from remailDetail");
	while(rs.next()==true)
	{
		if(to.equals(rs.getString(1)))
		{
			st2.executeUpdate("insert into inbox values('"+session.getAttribute("Email")+"','"
				+to+"','"+subject+"','"+message+"')");
%>
				<jsp:include page="loginSuccess.jsp"/>
<%
		}
	}
%>