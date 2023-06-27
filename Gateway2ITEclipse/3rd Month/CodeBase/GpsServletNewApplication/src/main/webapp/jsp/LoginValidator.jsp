<%@ page errorPage="ErrorHandler"%>


<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	if (!(username.equals("Amit") && password.equals("password"))) {
		throw new RuntimeException("Invalid User...");
	} else {
%>
<%=username%>
Successfully Logged in...
<%
	}
%>
