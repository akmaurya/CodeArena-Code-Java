<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

	<style type="text/css">
		div#star {    color: orange;}
        div#status{position:fixed; font-size:24px;}
        div#wrap{width:800px; margin:0px auto;}
        div.newData{height:100px; background:#09F; margin:10px 0px;}   
    </style>
    
<link rel="stylesheet" href="<c:url value="/css/demo.css" />" />
<link rel="stylesheet" href="<c:url value="/css/header.css" />" />
    
    
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
  </head>
  <body bgcolor="#586575">
  <%@include file="header.jsp" %>
  
  	
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
	
    <div id="wrap">
    	<jsp:useBean id="item" class="com.web.ratex.model.ItemsVO" scope="request"></jsp:useBean>
    	<jsp:getProperty property="item_id" name="item"/><br/>
    	<jsp:getProperty property="name" name="item"/><br/>
    	<jsp:getProperty property="description" name="item"/><br/>
    	<jsp:getProperty property="created_on" name="item"/><br/>
    	<jsp:getProperty property="modified_on" name="item"/><br/>
    	<jsp:getProperty property="status" name="item"/>
    	<h3>${item.getName() }</h3>
    </div>
    
	
	<div id="star">
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star checked"></span>
		<span class="fa fa-star"></span>
		<span class="fa fa-star"></span>
	</div>
	
  </body>
</html>