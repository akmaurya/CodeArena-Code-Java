<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/demo.css">
	<link rel="stylesheet" type="text/css" href="css/header.css">
<style>
body {font-family: "Lato", sans-serif;}

/* Style the tab */
div.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
div.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
div.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
div.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    -webkit-animation: fadeEffect 1s;
    animation: fadeEffect 1s;
}

/* Fade in tabs */
@-webkit-keyframes fadeEffect {
    from {opacity: 0;}
    to {opacity: 1;}
}

@keyframes fadeEffect {
    from {opacity: 0;}
    to {opacity: 1;}
}

body { padding: 2em; }


/* Shared */
.loginBtn {
  box-sizing: border-box;
  position: relative;
  /* width: 13em;  - apply for fixed size */
  margin: 0.2em;
  padding: 0 15px 0 46px;
  border: none;
  text-align: left;
  line-height: 34px;
  white-space: nowrap;
  border-radius: 0.2em;
  font-size: 16px;
  color: #FFF;
}
.loginBtn:before {
  content: "";
  box-sizing: border-box;
  position: absolute;
  top: 0;
  left: 0;
  width: 34px;
  height: 100%;
}
.loginBtn:focus {
  outline: none;
}
.loginBtn:active {
  box-shadow: inset 0 0 0 32px rgba(0,0,0,0.1);
}


/* Facebook */
.loginBtn--facebook {
  background-color: #4C69BA;
  background-image: linear-gradient(#4C69BA, #3B55A0);
  /*font-family: "Helvetica neue", Helvetica Neue, Helvetica, Arial, sans-serif;*/
  text-shadow: 0 -1px 0 #354C8C;
}
.loginBtn--facebook:before {
  border-right: #364e92 1px solid;
  background: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/14082/icon_facebook.png') 6px 6px no-repeat;
}
.loginBtn--facebook:hover,
.loginBtn--facebook:focus {
  background-color: #5B7BD5;
  background-image: linear-gradient(#5B7BD5, #4864B1);
}


/* Google */
.loginBtn--google {
  /*font-family: "Roboto", Roboto, arial, sans-serif;*/
  background: #DD4B39;
}
.loginBtn--google:before {
  border-right: #BB3F30 1px solid;
  background: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/14082/icon_google.png') 6px 6px no-repeat;
}
.loginBtn--google:hover,
.loginBtn--google:focus {
  background: #E74B37;
}
</style>
</head>
<body>
 <%@include file="/jsp/header.jsp" %>
<h3>RateX Login</h3>

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'login')">Login</button>
  <button class="tablinks" onclick="openCity(event, 'signup')">Sign up</button>
</div>

<div id="login" class="tabcontent">
  <h3>Login</h3>
  <div>
		<h1>Login with...</h1>
		<button class="loginBtn loginBtn--facebook">
  			Login with Facebook
		</button>

		<button class="loginBtn loginBtn--google">
			Login with Google
		</button>
		<br/>
		<br/>
		<table>
		<tr><td><label for="email">Email id</label></td><td><input type="text" name="email" id="email"></td></tr>
		<tr><td><label for="password">Password</label></td><td><input type="password" name="password" id="password"></td></tr>
		</table>
		
		<br/>
		<div class="in">
			<table>
				<tr>
					<td><a class="button b1" href="#">Submit</a><td>
				</tr>
			</table>
		</div>    	
		<br/>
		<div class="in">
			<table>
				<tr>
					<td><a class="button b1" href="login.jsp">Forgot password?</a><td>
				</tr>
				<tr>
					<td><a class="button b1" onclick="openCity(event, 'signup')">Doesn't have? Create one</a><td>
				</tr>
			</table>
		</div>
	</div>
</div>

<div id="signup" class="tabcontent">
  <h3>Sign up</h3>
  <div>
		<h1>Sign up with...</h1>
		<button class="loginBtn loginBtn--facebook">
  			Sign up with Facebook
		</button>

		<button class="loginBtn loginBtn--google">
			Sign up with Google
		</button>
		<br/>
		<br/>
		<table>
		<tr><td><label for="name">Name</label></td><td><input type="text" name="name" id="name"></td></tr>
		<tr><td><label for="email">Email</label></td><td><input type="text" name="email" id="email"></td></tr>
		<tr><td><label for="password">Password</label></td><td><input type="password" name="password" id="password"></td></tr>
		<tr><td><label for="confirmpassword">Confirm Password</label></td><td><input type="password" name="confirmpassword" id="confirmpassword"></td></tr>
		</table>
		
		<br/>
		<div class="in">
			<table>
				<tr>
					<td><a class="button b1" href="#">Submit</a><td>
				</tr>
			</table>
		</div>    	
		<br/>
		<div class="in">
			<table>
				<tr>
					<td><a class="button b1" onclick="openCity(event, 'login')">Already have account? Login</a><td>
				</tr>
			</table>
		</div>
	</div>
</div>

<script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
</script>
     
</body>
</html> 