<%@ page import="java.sql.*"%>
<html>
	<body bgcolor="#abcdef">

	<%
		String name="";
		Connection conn1=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ=D:/Tom Cat/Tomcat 5.5/webapps/jsp-examples/MyProgrames/remail/remail.accdb");
		Statement st1=conn1.createStatement();
		String email=""+session.getAttribute("Email");
		ResultSet rs1=st1.executeQuery("select name from remailDetail where Email='"+email+"'");
		if(rs1.next()==true)
		{
			name=rs1.getString(1);
	%>
			<h4>Welcome Mr./Mrs. <%=name%>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="logOut.jsp">Log Out</a></h4><br>

			<table>
				<tr>
					<td style="width:200;" >
						<h3><a href="compose.html">Compose Mail</a><br><br>
						<a href="inbox.jsp">Inbox</a></h3>
					</td>
					<td style="width:500">
						<%	
							String emailfrom="",subject="",message="";
							email=""+session.getAttribute("Email");
							Connection conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ=D:/Tom Cat/Tomcat 5.5/webapps/jsp-examples/MyProgrames/remail/inbox.accdb");
							Statement st=conn.createStatement();
							ResultSet rs=st.executeQuery("select * from inbox where EmailTo='"+email+"'");
							
						%>
							<table>
								<tr>
									<td style="color:Blue;">
										<h3>Inbox</h3>
									</td>
								</tr>
								<tr>
									<td style="width:300;">
										<h4>From</h4>
									</td>
									<td style="width:200;">
										<h4>Subject</h4>
									</td>
									<td style="width:100;">
										<h4>Message</h4>
									</td>
								</tr>

						<%
								while(rs.next()==true)
								{
									String sub=rs.getString(3);
							%>
								<tr>
									<td>
										<a href="display.jsp"><%=rs.getString(1)%></a>
									</td>
									<td>
										<a href="display.jsp?subj=<%=sub%>"><%=sub%></a>
									</td>
									<td>
										<a href="display.jsp"><%=rs.getString(4)%></a>
									</td>
								</tr>
							<%
								}
							%>


							</table>
						<%
							conn.close();
						%>					
					</td>
				</tr>
			</table>
	<%
			conn1.close();
		}	
	%>
	</body>
</html>
