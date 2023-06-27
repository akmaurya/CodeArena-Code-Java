<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<title>Log In - RateX</title>
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<link rel="stylesheet" type="text/css" href="css/header.css">
</head>
<body>
 <%@include file="/jsp/header.jsp" %>
	<div>
		<h1>Login with...</h1>
		<table>
		<tr><td><label for="email">Email id</label></td><td><input type="text" name="email" id="email"></td></tr>
		<tr><td><label for="password">Password</label></td><td><input type="password" name="password" id="password"></td></tr>
		</table>
		
		<br/>
		<div class="in">
			<table>
				<tr>
					<td><a class="button b1" href="#">Submit</a><td>
				</tr>
			</table>
		</div>    	
		<br/>
		<div class="in">
			<table>
				<tr>
					<td><a class="button b1" href="login.jsp">Forgot password?</a><td>
				</tr>
				<tr>
					<td><a class="button b1" href="login.jsp">Doesn't have? Create one</a><td>
				</tr>
			</table>
		</div>
	</div>    	
</body>
</html>
