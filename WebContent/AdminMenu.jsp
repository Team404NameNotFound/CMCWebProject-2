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
	<a href="ViewUniversities.jsp">Manage universities</a>
	<br>
	<a href="ViewUsers.jsp">Manage users</a>
	<br>
</body>
</html>