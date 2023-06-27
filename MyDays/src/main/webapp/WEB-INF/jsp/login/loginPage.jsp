<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login | My Days</title>
	<meta charset="UTF-8">
</head>
<body>
	${ERROR}
</body>
<body>
	<form:form method="post" action="loginValidate" modelAttribute="login">
		<div style="align-content: center;">
			<table>
				<tr>
					<td>
						<form:label path="">User Name</form:label>
					</td>
					<td>
						<form:input path="userId"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="">Password</form:label>
					</td>
					<td>
						<form:input path="password"/>
					</td>
				</tr>
				<tr>
					<td colspan="">
						<form:button type="submit">Login</form:button>
					</td>
				</tr>
			</table>			
		</div>
	</form:form>
</body>
</html>