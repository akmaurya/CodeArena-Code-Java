<%@ page import = "model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact|Home</title>
	 
</head>
<body>

	<%User user = (User)session.getAttribute("User");
			String status = "";
			if(user != null)
				{
			%>
			<table>
				<tr>
					<td><h1>Hi! <%= user.getName() %></h1>
					<td><form action="/Contact/LogOut">
							<input type="submit" name="logout" value="Log Out">
						</form>
					</td>
				</tr>
			</table>
			
			<h2>Welcome to Contact</h2>
			<table>
				<tr>
					<td>Full Name :</td><td><%=user.getName()%></td>
				</tr>
				<tr>
					<td>Contact No. :</td><td><%=user.getContactNo()%></td>
				</tr>
				<tr>
					<td>Email :</td><td><%=user.getEmail()%></td>
				</tr>
				<tr>
					<td>Status :</td><td>
					<%if(user.getDeleted() == "0")
						status = "Not Active";
					else
						status = "Active";
						%>
						<%= status%>
					</td>
				</tr>
			</table>
			<%}%>
			
			<h4>Add new Contact</h4>
				<form name="addcontactform" method="post" action="/Contact/AddContact">
					<table>
						<tr>
							<td>Name :</td><td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td>Contact No. :</td><td><input type="text" name="contactno"></td>
						</tr>
						<tr>
							<td>Email ID :</td><td><input type="text" name="email"></td>
						</tr>
						
						<tr>
							<td><input type="submit" name="add" value="Add"></td>
						</tr>
					</table>
				</form>
			
</body>
</html>