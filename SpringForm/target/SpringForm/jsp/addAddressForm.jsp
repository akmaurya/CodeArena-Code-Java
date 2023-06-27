<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Address</title>
</head>
<body>
	 <form action="addAddress" method="get">
		<div><br/><br/><br/><br/><br/><br/>
			<input name="name" id="name" width="30px"/>
			<input value="Submit" type="submit"/>
		</div>
	</form> 
	<form:form action="processAddAddress" modelAttribute="addressBean">
	Pincode:  <form:input path="addressBean.pinCode"/>
	<input value="Submit" type="submit"/>
	</form:form>
</body>
</html>