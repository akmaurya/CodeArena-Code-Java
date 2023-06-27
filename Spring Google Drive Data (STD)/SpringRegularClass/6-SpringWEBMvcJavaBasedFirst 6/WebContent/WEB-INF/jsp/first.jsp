<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="spring" uri="/WEB-INF/tld/spring_form.tld" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:form modelAttribute="pageObj" action="/SpringMvcJavaBasedFirst/submit">
    <input type="text" name="first"><br> 

    <spring:input path="name"/><br>


 

    <button type="submit" >Submit</button>


</spring:form>

</body>
</html>