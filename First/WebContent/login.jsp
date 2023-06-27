<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Example</title>
</head>
<body background="images1.jpg">
	<html:form action="/login" focus="userName">
	<table>
		<tr><td>Username:</td><td><html:text property="userName" /></td><td><html:errors property="userName_e"/></td></tr>
		<tr><td>Password:</td><td><html:password property="password" /></td><td><html:errors property="password_e"/></td></tr>
	</table>
	<html:submit value="Login" />
	</html:form>

</body>
</html>