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
  <h1>Oh no! There was an error!</h1>
<p><%= exception.getMessage() %></p>
</div>
   </body>
</html>