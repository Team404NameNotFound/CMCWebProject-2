<%@ page language="java"
	import="cmc.interaction.*,cmc.entity.*, java.util.*,cmc.functionality.*"%>

<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>
<body>
<%
		AdminInteraction admin = (AdminInteraction) session.getAttribute("interaction");
		Account adminAccount = admin.getAccount();
	%>
	Welcome : <%=adminAccount.getUsername()%>
	<br>
	<a href="ViewUniversities.jsp?username="+<%=request.getParameter("username")%>>Manage Universities</a>
	<br>
	<a href="ViewUsers.jsp?username="+<%=request.getParameter("username")%>>Manage Users</a>
	<br>
</body>
</html>