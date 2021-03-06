<%@page language="java" import="cmc.entity.*, cmc.functionality.*, cmc.interaction.*, java.util.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<%@ page errorPage = "ErrorHandlingStudent.jsp" %>

<html>
<head>
<title></title>
</head>

<style>
<%@include file="styleCMC.css" %>
<%@include file="topNavBarStyle.css" %>
tr:nth-child(even) {background-color: #ea6d6d;}
tr:hover {background-color:#F7F7D1;}
</style>

<div class="header">
  <h1>ChooseMyCollege</h1>
  <p>Saved Schools</p>
</div>
<div class="topnav">
  <a href="StudentMenu.jsp">Menu</a>
  <a href="LogoutAction.jsp">Logout</a>
</div>
<br>
<br>

<body>
   <%
		StudentInteraction student = (StudentInteraction) session.getAttribute("interaction");
		Account studentAccount = student.getAccount();
		ArrayList<UserSavedSchool> savedSchools = new ArrayList<UserSavedSchool>();
		savedSchools = student.viewSavedSchools();
		if (savedSchools.size() == 0){%>
		<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="0"
		class="center">
		<tbody>
			<tr align="center">

				<td colspan="8" rowspan="1" style="vertical-align: top;"><a
					>Sorry, you have no saved schools</a></td>

			</tr>
			</tbody>
		<%
		}
		else{
	%>
	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="0"
		class="center">
		<tbody>
			<tr align="center">

				<td colspan="8" rowspan="1" style="vertical-align: top;"><a
					href="CompareSchools2.jsp">Compare Schools by Score</a></td>

			</tr>
			<%
		}
				for (int i = 0; i < savedSchools.size(); i++) {
			%>
			<tr>
			<td style="vertical-align: top;">
			<form method="post" action="RemoveSavedSchool.jsp"
						name="Remove">
						<input name="RemoveSavedSchool.jsp" value="Remove"
							type="submit" class="button"> <input name="savedSchool"
							value="<%=savedSchools.get(i).getName() %>" type="hidden">
					</form>
			</td>
				<td style="vertical-align: top;">
					<%
						out.println(savedSchools.get(i).getName() + " (added on: " + savedSchools.get(i).getDateAdded() + ")");
					%>
				</td>
				<td style="vertical-align: top;">
					<form method="post" action="ViewSavedSchoolDetails.jsp"
						name="View">
						<input name="ViewSavedSchoolDetails.jsp" value="View"
							type="submit" class="button"> <input name="savedSchool"
							value="<%=savedSchools.get(i).getName()%>" type="hidden">
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>
