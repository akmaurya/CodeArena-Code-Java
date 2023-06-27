<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Form</title>
</head>
	<body>
		<h1>Add New Employee</h1>
		<form:form method="post" action="save">
			<table>
				<%-- <tr>
					<td>Name :</td>
					<td><form:input path="firstName" /></td>
					<td><form:input path="middleName" /></td>
					<td><form:input path="lastName" /></td>
				</tr> --%>
				
				<tr>
					<td>Age :</td>
					<td><form:input path="age" /></td>
				</tr>
				
				<tr>
					<td>Gender :</td>
					<td><form:input path="gender" /></td>
				</tr>
				
				
				<tr>
					<td>Contact No. :</td>
					<td><form:input path="contactNo" /></td>
				</tr>
				
				<tr>
					<td>Email :</td>
					<td><form:input path="email" /></td>
				</tr>
				
				<tr>
					<td>Address :</td>
				<tr>
					<td><form:input path="address1" /></td> 
					<td><form:input path="address2" /></td>
					<td><form:input path="address3" /></td>
				</tr>
				
				<tr>
					<td>District :</td>
					<td><form:input path="district" /></td>
				</tr>
				
				<tr>
					<td>State :</td>
					<td><form:input path="state" /></td>
				</tr>
				<tr>
					<td>PIN Code :</td>
					<td><form:input path="pinCode" /></td>
				</tr>
				<tr>
					<td>Country :</td>
					<td><form:input path="country" /></td>
				</tr>
					
				<tr>
					<td></td>
					<td><input type="submit" value="Save" /></td>
				</tr>
			</table>
		</form:form>
		
		
		
		
		
		<%-- <form:form method="post" action="save">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Salary :</td>    
          <td><form:input path="salary" /></td>  
         </tr>   
         <tr>    
          <td>Designation :</td>    
          <td><form:input path="designation" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form> --%>
		
		
	</body>
</html>