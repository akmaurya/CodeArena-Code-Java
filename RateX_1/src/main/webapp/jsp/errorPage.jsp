<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
  <%@include file="header.jsp" %></br>
  <h1>Sorry!</h1> 
    <h2>${errorMsg}</h2>
    <h2>Go to <a href="home">Home</a> page</h2>
</body>
</html>