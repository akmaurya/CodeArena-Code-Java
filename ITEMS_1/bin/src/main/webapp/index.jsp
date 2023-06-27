<%@ page import="com.items.model.Client"%> 
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="Flatfy Free Flat and Responsive HTML5 Template ">
    <meta name="author" content="">

    <title>ITEMS</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
 
    <!-- Custom Google Web Font -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
	
    <!-- Custom CSS-->
    <link href="css/general.css" rel="stylesheet">
	
	 <!-- Owl-Carousel -->
    <link href="css/custom.css" rel="stylesheet">
	<link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">
	
	<!-- Magnific Popup core CSS file -->
	<link rel="stylesheet" href="css/magnific-popup.css"> 
	
	<script src="js/modernizr-2.8.3.min.js"></script>  

</head>

<body id="home">

	<!-- Preloader -->
	<div id="preloader">
		<div id="status"></div>
	</div>
	
	<!-- FullScreen -->
    <div class="intro-header">
		<div class="col-xs-12 text-center abcen1">
			<h1 class="h1_home wow fadeIn" data-wow-delay="0.4s">ITEMS</h1>
			<h3 class="h3_home wow fadeIn" data-wow-delay="0.6s">All Your ITEMS Are Here</h3>


		<%
			Client client = null;
			boolean status=false;
			client = (Client)session.getAttribute("client");
			if (client == null) 
			{
				status = false;
		%>
			<ul class="list-inline intro-social-buttons">
				<li><a href="#login" class="btn  btn-lg mybutton_cyano wow fadeIn" data-wow-delay="0.8s"><span class="network-name">Login</span></a>
				</li>
				<li id="download" ><a href="#createAccount" class="btn  btn-lg mybutton_standard wow swing wow fadeIn" data-wow-delay="1.2s"><span class="network-name">Create Account</span></a>
				</li><br><br>
				<li>
				<%
					String msg1 = (String) request.getAttribute("errorMessage");
					String msg2 = (String) request.getAttribute("successMessage");
					if (msg1 != null) 
					{
				%>
						<h4 style="color: #ff0000">
						<%=msg1%>
						</h4>
				<%
					}
					else if(msg2 != null)
					{
				%>
						<h4 style="color: #00ffd8">
						<%=msg2%>
						</h4>
				<%
					}
				%>
				</li>
			</ul>
		<%
			}
			else
			{
				status = true;
		%>
			<ul class="list-inline intro-social-buttons">
				
				<li id="download" ><a href="#updateDetail" class="btn  btn-lg mybutton_standard wow swing wow fadeIn" data-wow-delay="1.2s"><span class="network-name">Update Detail</span></a>
				</li>
				<li><a href="/ITEMS/clientLogout" class="btn  btn-lg mybutton_cyano wow fadeIn" data-wow-delay="0.8s"><span class="network-name">Logout</span></a>
				</li><br><br>
				<li>
				<%
					String msg1 = (String) request.getAttribute("errorMessage");
					String msg2 = (String) request.getAttribute("successMessage");
					if (msg1 != null) 
					{
				%>
						<h4 style="color: #ff0000">
						<%=msg1%>
						</h4>
				<%
					}
					else if(msg2 != null)
					{
				%>
						<h4 style="color: #00ffd8">
						<%=msg2%>
						</h4>
				<%
					}
				%>
						<h4 style="color: #00ffd8">
						Welcome : <%=client.getClientName()%>
						</h4>
				<%
				}
				%>
				</li>
			</ul>	

		</div>    

        <!-- /.container -->

		<%@ include file="container.jsp" %>	

    </div>

	

	<%
		if(status==true)
		{
	%>
		<!-- What is -->
		
		<%@ include file="whatis.jsp" %>
	<%
		}
		else
		{
	%>
		<!-- login -->
	
		<%@ include file="login.jsp" %>
		
		<!-- create account -->
		
		<%@ include file="createAccount.jsp" %>
	<%
		}
	%>

	<!-- footer -->
	
	<%@ include file="footer.jsp" %>

	<!-- scripts -->
	
	<%@ include file="scripts.jsp" %>
	
    

    
</body>

</html>