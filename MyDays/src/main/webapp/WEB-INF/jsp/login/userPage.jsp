<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login | My Days</title>
	<meta charset="UTF-8">
</head>
<body>
	<div>
		<table>
			<tr>
				<td colspan=2>
					Hi! ${user.getName()}
				</td>
			</tr>
			<tr>
				<td>
					Name	:
				</td>
				<td>
					${user.getName()}
				</td>
			</tr>
			<tr>
				<td colspan="1">
					<form:form method="get" action="userProfile" modelAttribute="login">
						<div style="align-content: center;">
							<form:button type="submit">Profile</form:button>
						</div>
					</form:form>
				</td>
			</tr>
		</table>
	</div>
	
	
	
</body>
</html>