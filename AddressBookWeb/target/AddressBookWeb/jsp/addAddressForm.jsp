<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Address</title>
</head>
<body>
	<form action="addAddress">
		<div><br/><br/><br/><br/><br/><br/>
			<table  align="center" width="50%">
				<tr>
					<td>Name</td>
					
					<td><input name="name1" id="name1" width="30px"></td>
					<td><input name="name2" id="name2" width="30px"></td>
					<td><input name="name3" id="name3" width="30px"></td>
					
					
				</tr>
				<tr>
					<td colspan="3">Age</td>
					
					<td><input name="age" id="age" width="50px"></td>
			
				</tr>
				<tr>
					<td>Gender</td>
					
					<td><input name="gender" id="gender" width="50px"></td>
					
				</tr>
				<tr>
					<td>Address</td>
					
					<td><input name="address1" id="address1" width="30px"></td>
					<td><input name="address2" id="address2" width="30px"></td>
					<td><input name="address3" id="address3" width="30px"></td>
					
				</tr>
				<tr>
					<td>Pin Code</td>
					
					<td><input name="pinCode" id="pinCode" width="50px"></td>
					
				</tr>
				<tr>
					<td>District</td>
					
					<td><input name="district" id="district" width="50px"></td>
					
				</tr>
				<tr>
					<td>State</td>
					
					<td><input name="state" id="state" width="50px"></td>
					
				</tr>
				<tr>
					<td>Country</td>
					
					<td><input name="country" id="country" width="50px"></td>
					
				</tr>
				<tr>
					<td>Contact No.</td>
					
					<td><input name="contactNo" id="contactNo" width="50px"></td>
					
				</tr>
				<tr>
					<td>Email</td>
					
					<td><input name="email" id="email" width="50px"></td>
					
				</tr>
				
				<tr>
					<td colspan="4" align="center">
						<input type="submit" name="submit" value="Add" width="20px">					
					</td>
				</tr>
			</table>
		</div>
		<body>
		    Statys : ${addressAdditionMessage}
		</body>
	</form>
</body>
</html>