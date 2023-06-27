<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<link rel="stylesheet" type="text/css" href="css/header.css">

</head>
<html>
	<body>
		<div class="cn">
			<div style="float:left;">
				<table>
					<tr>
						<fmt:bundle basename="messages">
						<td><fmt:message key="ratex.header.title" /></td>
						</fmt:bundle>
					</tr>
				</table>
			</div>
			<div style="float:right;">
				<table>
					<tr>
						<td><a class="button b1" href="jsp/login/logintab.jsp">Log In</a></td>
						<td><a class="button b1" href="jsp/login/logintab.jsp">Sign Up</a></td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>