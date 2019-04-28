<%@ page language="java" import="cmc.interaction.*,  java.util.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compare Schools by Score</title>
<%
StudentInteraction stud = (StudentInteraction) session.getAttribute("interaction");

%>
</head>

<style>
<%@include file="styleCMC.css" %>
<%@include file="topNavBarStyle.css" %>
</style>

<div class="header">
  <h1>ChooseMyCollege</h1>
  <p>Compare Schools by Score</p>
</div>
<div class="topnav">
  <a href="StudentMenu.jsp">Menu</a>
  <a href="LogoutAction.jsp">Logout</a>
</div>
<br>
<br>

<body>
<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="2">
		<tbody>
			<tr>
				<td style="vertical-align: top;">School</td>
				<td style="vertical-align: top; text-align: center;">Average SAT Score
				</td>
			</tr>


			<%
			ArrayList<String> schoolScores = stud.compareSchoolsByScore();
				for (int i = 0; i < schoolScores.size(); i++) {
			%>
			<tr>
				<td style="vertical-align: top;">
					<%
						int pos = schoolScores.get(i).lastIndexOf(" ");
						out.println(schoolScores.get(i).substring(0, pos));
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schoolScores.get(i).substring(pos));
					%>
				</td>
			</tr>
			<%}%>
		</tbody>
	</table>
</body>
</html>