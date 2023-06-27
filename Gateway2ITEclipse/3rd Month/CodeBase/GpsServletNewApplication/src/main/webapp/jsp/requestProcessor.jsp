<H1>Test App for Request Scope</H1>
<%
	String name = request.getParameter("uname");
	out.print("welcome " + name);
%>
