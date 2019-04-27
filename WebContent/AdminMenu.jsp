<%@ page language="java"
	import="cmc.interaction.*,cmc.entity.*, java.util.*,cmc.functionality.*"%>
<%@include file="verifyLoginCMC.jsp" %>

<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>
<style>
<%@include file="styleCMC.css" %>
<%@include file="topNavBarStyle.css" %>
</style>

<body>

<%
		AdminInteraction admin = (AdminInteraction) session.getAttribute("interaction");
		Account adminAccount = admin.getAccount();
	%>
		<div class="header">
  <h1>Admin Menu</h1>
  <p>Welcome : <%=adminAccount.getUsername()%></p>
</div>
<div class="topnav">
  <a class="active" href="AdminMenu.jsp">Menu</a>
  <a href="ViewUniversities.jsp">Manage universities</a>
  <a href="ViewUsers.jsp">Manage users</a>
  <a href="LogoutAction.jsp.jsp">Log out</a>
</div>

</body>
</html>