<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelloWorld page</title>
</head>
<body>
	<%-- Greeting : ${greeting}
	<div>
		<form action="helloagain">
			<input type="text" name="name" /> 
			<input type="submit" name="submit" value="submit" />
		</form>
		<a href="addressForm">Add Address</a>
	</div> --%>
	<div>
		<table>
			<tr><td><a href="addressForm">Add Address</a></td></tr>
			<tr><td><a href="editAddressForm">Edit Address</a></td></tr>
			<tr><td><a href="showAddress">Show Address</a></td></tr>
			<tr><td><a href="deleteAddress">Delete Address</a></td></tr>
			
		</table>
	</div>
</body>
</html>