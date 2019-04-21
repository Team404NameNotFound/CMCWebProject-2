<%@ page language="java"
	import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>

<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>
<body>
	Welcome : <%=request.getParameter("username")%>
	<br>
	<a href="StudentEditUser.jsp?username="+<%=request.getParameter("username")%>>Manage my profile</a>
	<br>
	<a href="ViewSavedSchools.jsp?username="+<%=request.getParameter("username")%>>Manage my saved schools</a>
	<br>
	<a href="Search.jsp?username="+<%=request.getParameter("username")%>>Search for schools</a>
	<br>
	<a href="TakePersonalityQuiz.jsp?username="+<%=request.getParameter("username")%>>Take personality quiz</a>
	<br>
</body>
</html>