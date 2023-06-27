	<%@ page import="java.sql.*"%>

	<%
			String name="",email="",password="",repassword="",age="",gender="",mobile="",location="";
			name=request.getParameter("name");
			email=request.getParameter("email");
			password=request.getParameter("password");
			repassword=request.getParameter("repassword");
			age=request.getParameter("age");
			gender=request.getParameter("gender");
			mobile=request.getParameter("mobile");
			location=request.getParameter("location");
			System.out.println("Till this ok1");
			if(false)
			{
	%>				
				<html>
				<body bgcolor="#abcdef">
					<a href="Login.html">Login Page</a>
					<form method="get" action="http://127.0.0.1:8081/jsp-examples/MyProgrames/remail/createAccount.jsp">
						<center>
							<table bgcolor="#7c8dd9">
								<tr>
									<td style="width:400;">
										<center><h3>
											<h4>Name&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="name"	style="width:250;"><br>
											<hr></hr>
											Email&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="email" style="width:250;"><br><br>
											Password&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="password" name="password" style="width:250;"><br><br>

											Re Password&nbsp&nbsp&nbsp&nbsp&nbsp<input type="password" name="repassword" style="width:250;"><br>
											<hr></hr>
											Age&nbsp&nbsp<select name="age" style="width:50;">
												<option value="11">11</option>
												<option value="12">12</option>
												<option value="13">13</option>
												<option value="14">14</option>
												<option value="15">15</option>
												<option value="16">16</option>
												<option value="17">17</option>
												<option value="18">18</option>
												<option value="19">19</option>
												<option value="20">20</option>
												<option value="21">21</option>
												<option value="22">22</option>
												<option value="22">22</option>
												<option value="23">23</option>
												<option value="24">24</option>
												<option value="25">25</option>
												<option value="26">26</option>
												<option value="27">27</option>
												<option value="28">28</option>
												<option value="29">29</option>
												<option value="30">30</option>
											</select>
											&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspGender&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspMale<input type="radio" name="gender" value="male" checked>&nbsp&nbsp
											Female<input type="radio" name="gender" value="female">
											<hr></hr>
											Mobile No.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="mobile" style="width:250"><br><br>
											Location&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<select name="location" style="width:250;">
												<option value="India">India</option>
												<option value="Austrelia">Austrelia</option>
												<option value="America">America</option>
											</select><br><br>
											<input type="submit" value="Submit" style="width:150; height:30; color:blue;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="reset" value="Reset" style="width:100; height:30; color:blue;"></td>
										</h3></center>
									</td>
								</tr>
							</table>
						</center>
					</form>
				</body>
			</html>
	<%		}
			else
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Till this ok2");
				Connection conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ=D:/Tom Cat/Tomcat 5.5/webapps/jsp-examples/MyProgrames/remail/remail.accdb");
				System.out.println("Till this ok3");
				Statement st=conn.createStatement();
				System.out.println("Till this ok4");
				st.executeUpdate("insert into remailDetail values('"+name+"','"+email+"','"+password+"','"+age+"','"+gender+"','"+mobile+"','"+location+"')");
				System.out.println("Till this ok5");
				conn.close();
				%>
					<html>
						<body bgcolor="#abcdef">
							<center>
								<h2 style="color:green;">
									Successfuly Created Your Account.</h2><br><br>
									<h3>Now You Can <a href="Login.html"> Login</a></h3>
								
							</center>
						</body>
					</html>
				<%
			}

		%>	

	