<%@page language="java" import="cmc.entity.*"
		import="cmc.functionality.*" import="cmc.interaction.*"
		import="java.util.ArrayList"%>
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
  <p>Search Results</p>
</div>
<div class="topnav">
  <a href="StudentMenu.jsp">Menu</a>
  <a href="LogoutAction.jsp">Logout</a>
</div>
<br>
<br>

<body>
	
	<%
	   StudentInteraction student = (StudentInteraction)session.getAttribute("interaction");
	   ArrayList<University> matches = student.getSfCon().getSearchCon().getMatches();
	%>
	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="0">
		
			
			<% if (matches.size() == 0){%>
					<tbody>
			<tr align="center">

				<td colspan="8" rowspan="1" style="vertical-align: top;"><a
					>Sorry, there are no matches</a></td>

			</tr>
				<% }
			else{%>
			
			<tbody>
			<tr align="center">

				<td colspan="8" rowspan="1" style="vertical-align: top;"><a
					>MATCH SCHOOLS</a></td>

			</tr>
			
				<%for (int i = 0; i < matches.size(); i++) {
			%>
			<tr>
				<td style="vertical-align: top;">
					<form method="post" action="SaveSchool.jsp" name="SaveSchool">
						<input name="Save" value="Save" type="submit" class="button"> <input
							name="School" value="<%=matches.get(i).getName()%>"
							type="hidden">
					</form>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(matches.get(i).getName());
					%>
				</td>
				<td style="vertical-align: top;">
					<form method="post" action="ViewAdditionalRecommended.jsp"
						name="View School Details">
						<input name="View" value="View"
							type="submit"class="button"> <input name="School"
							value="<%=matches.get(i).getName()%>" type="hidden">
					</form>
				</td>
			</tr>
			<%}
			}%>
		</tbody>
	</table>
</body>
</html>
