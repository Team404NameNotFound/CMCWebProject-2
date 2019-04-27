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
</style>
<body>

   <%
		StudentInteraction student = (StudentInteraction) session.getAttribute("interaction");
		Account studentAccount = student.getAccount();
	%>
<div class="header">
  <h1>ChooseMyCollege</h1>
  <p>Welcome : <%=studentAccount.getUsername()%></p>
</div>
	<br>
	<a href="StudentEditUser.jsp">Manage my profile</a>
	<br>
	<a href="ViewSavedSchools.jsp">Manage my saved schools</a>
	<br>
	<a href="Search.jsp">Search for schools</a>
	<br>
	<a href="TakePersonalityQuiz.jsp">Take personality quiz</a>
	<br>
	<br>
	<a href="LogoutAction.jsp">Logout</a>
</body>
</html>