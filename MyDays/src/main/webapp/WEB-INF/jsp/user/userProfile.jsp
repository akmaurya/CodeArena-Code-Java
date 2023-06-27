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
				<td>
					ID	:
				</td>
				<td>
					${user.getId()}
				</td>
			</tr>
			<tr>
				<td>
					Age	:
				</td>
				<td>
					${user.getAge()}
				</td>
			</tr>
		</table>
	</div>
	
	
	
</body>
</html>