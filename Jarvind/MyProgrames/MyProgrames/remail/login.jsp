<%@ page import="java.sql.*"%>

<%	
	String email="",password="";
	email=request.getParameter("email");
	password=request.getParameter("password");
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ=D:/Tom Cat/Tomcat 5.5/webapps/jsp-examples/MyProgrames/remail/remail.accdb");
	Statement st=conn.createStatement();
	System.out.println(""+email+"----"+password);
	ResultSet rs=st.executeQuery("select email, password from remailDetail where Email='"+email+"' and Password='"+password+"'");
	if(rs.next()==true)
	{
		session.setAttribute("Email",email);
%>
		<jsp:forward page="loginSuccess.jsp"/>
<%	}
	else
	{	
%>
		<jsp:forward page="loginError.html"/>
<%	}
	conn.close();
%>
