<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h1>New User Registration Form - ${headerMsg}</h1>
	<form:errors path="user.*" />
	<form action="newUserSubmitRegistrationForm" method="post">
		<p>
			User's Name : <input type="text" name="userName" value="${user.userName}"/>
		</p>
		<p>
			Email Id : <input type="text" name="emailId" value= "${user.emailId}"/>
		</p>
		<p>
			Password : <input type="password" name="password" />
		</p>
		<p>
			Phone : <input type="text" name="phone" />
		</p>
		<p>
			DOB : <input type="text" name="dob"/>
		</p>
		<p>
			Select Preferred Location : <select name="preferredLocation"
				multiple="multiple">
				<option value="Delhi">Delhi</option>
				<option value="Noida">Noida</option>
				<option value="Gurgaon">Gurgaon</option>
				<option value="Banglore">Banglore</option>
				<option value="Mumbai">Mumbai</option>
			</select>
		</p>
		<p>
			Country : <input type="text" name="userAddress.country" />
		</p>
		<p>
			City : <input type="text" name="userAddress.city" />
		</p>
		<p>
			Street : <input type="text" name="userAddress.street" />
		</p>
		<p>
			Pincode : <input type="text" name="userAddress.pincode" />
		</p>
		<input type="submit" value="Submit it by clicking here" />
	</form>
</body>
</html>