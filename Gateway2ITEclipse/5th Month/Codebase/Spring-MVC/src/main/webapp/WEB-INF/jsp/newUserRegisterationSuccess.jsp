<html>
<body>
	<h1>Congratulations ${user.userName}!! ${headerMsg}</h1>
	<h2>User details are</h2>
	<p>Email : ${user.emailId}</p>
	<p>Password : ${user.password}</p>
	<p>Phone : ${user.phone}</p>
	<p>DOB : ${user.dob}</p>
	<p>Preferred Location : ${user.preferredLocation}</p>
	<p>Country : ${user.userAddress.country}</p>
	<p>City : ${user.userAddress.city}</p>
	<p>Street : ${user.userAddress.street}</p>
	<p>Pincode : ${user.userAddress.pincode}</p>
</body>
</html>