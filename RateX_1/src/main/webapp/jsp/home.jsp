<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

	<style type="text/css">
        div#status{position:fixed; font-size:24px;}
        div#wrap{width:800px; margin:0px auto;}
        div.newData{height:100px; background:#09F; margin:10px 0px;}   
    </style>
    
   
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
  </head>
  <body bgcolor="#586575">
  <%@include file="header.jsp" %>
  <script type="text/javascript">
	     var myVar = '${objkey}';
		 var mytest = eval('(' + myVar + ')');
		 	 
		 var i = 0;
        function yHandler(){
			// Watch video for line by line explanation of the code
			// http://www.youtube.com/watch?v=eziREnZPml4
			var wrap = document.getElementById('wrap');
			var contentHeight = wrap.offsetHeight;
			var yOffset = window.pageYOffset; 
			var y = 0;
			y = y + contentHeight;
			if(y >= contentHeight) {
				// Ajax call to get more dynamic data goes here
			 
				wrap.innerHTML += '<div class="newData">'+ 
				mytest.items[i].name +'<br>'+ 
				mytest.items[i].description +'<form><h4><a href="/RateX/more?item_id='+mytest.items[i].item_id+'" target="_blank">Details</a></h4>'+
				'</div>';
				i++;
			}
			
			// var status = document.getElementById('status');
			// status.innerHTML = contentHeight+" | "+y;

		}
        window.onload = yHandler;
        window.onkeydown = yHandler;	
	    
    </script>
  	
  	<!-- Search items here -->
  	<br/>
	  <div class="in">
	  		<table>
	            <tr>
	               	<td><input class="button b1" type="text" placeholder="Your item is here" name="item" id="item"></td>
	               	<td><a class="button b1" href="#">Submit</a><td>
	               	
	        	</tr>
			</table>
	  </div>
<br>
	<!-- <div id="status">0 | 0</div> -->
    <div id="wrap"></div>
  </body>
</html>