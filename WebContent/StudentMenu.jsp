<%@ page language="java"
	import="cmc.interaction.*,cmc.entity.*, java.util.*,cmc.functionality.*"%>

<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>
<style>
body {background-image: url("bookBackground.jpg");
  height: 500px;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;}
table { border:ridge 5px red; background-color:#FED0C6; color:#000000;}
.header {
  padding: 20px;
  text-align: center;
  background: #FED0C6;
  color: black;
  font-size: 18px;
}
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