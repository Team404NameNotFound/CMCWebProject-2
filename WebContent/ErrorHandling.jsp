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
<%
AccountInteraction sessionUser = (AccountInteraction) session.getAttribute("interaction");
String menu = "";
if(sessionUser.getAccount().getUserType().equals("a")){
	menu = "AdminMenu.jsp";
	menu = "StudentMenu.jsp";
}
%>
  <a href=<%=menu%>>Menu</a>
  <a href="LogoutAction.jsp">Logout</a>
</div>
      <p><% exception.getMessage(); %></p>
   </body>
</html>