<%@ page language="java" import="cmc.interaction.*,  java.util.*"%>
<%@ page isErrorPage = "true" %>


<html>
   <head>
      <title>Show Error Page</title>
   </head>
   
<style>
	<%@include file="styleCMC.css" %>
	<%@include file="topNavBarStyle.css" %>
</style>
   <body>
<div class="header">
  <h1>ChooseMyCollege</h1>
<p>Oh no! There was an error!</p>
</div>
<div class="topnav">
  <a href="StudentMenu.jsp">Menu</a>
  <a href="LogoutAction.jsp">Logout</a>
</div>
      <p><% exception.getMessage(); %></p>
   </body>
</html>