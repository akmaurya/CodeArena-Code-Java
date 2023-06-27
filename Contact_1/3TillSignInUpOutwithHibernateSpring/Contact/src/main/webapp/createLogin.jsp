<%@ page import = "model.User" %>
<html>
	<title>Create Login</title>
	<body>
		<h2>Welcome to Contact</h2>
		<h4>Create a new Login Account here.</h4>
		<form name="createloginform" method="post" action="/Contact/CreateLogin">
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
					<td>Password :</td><td><input type="Password" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" name="createlogin" value="Create Login"></td><td><a href="index.jsp">Sign In</a></td>
				</tr>
			</table>
			<%String msg = (String)request.getAttribute("Message");
			
			if(msg != null)
			{
			%>
				<%= msg %>
			<%}%>
		</form>
	</body>
</html>
