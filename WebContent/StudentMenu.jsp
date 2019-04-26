<%@ page language="java"
	import="cmc.interaction.*,cmc.entity.*, java.util.*,cmc.functionality.*"%>

<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>
<body>
   <%
		StudentInteraction student = (StudentInteraction) session.getAttribute("interaction");
		Account studentAccount = student.getAccount();
	%>
	Welcome : <%=studentAccount.getUsername()%>
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