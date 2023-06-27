<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Form</title>
</head>
<body>
	
	Status : ${status}
	<div>
		<form action="address/add">
			<input type="text" name="name" /> 
			<input type="submit" name="submit" value="submit" />
		</form>
	</div>
	<a href="home">Back to Home</a>
</body>
</html>