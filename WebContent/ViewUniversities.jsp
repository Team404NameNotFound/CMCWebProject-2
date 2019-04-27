<%@page language="java" import="cmc.entity.*"
		import="cmc.functionality.*" import="cmc.interaction.*"
		import="java.util.ArrayList"%>
<%@include file="verifyLoginCMC.jsp" %>
<html>
<head>
<title></title>
</head>
<style>
<%@include file="styleCMC.css" %>
<%@include file="topNavBarStyle.css" %>
</style>
<div class="header">
  <h1>ChooseMyCollege</h1>
  <p>View Universities </p>
</div>
<div class="topnav">
  <a href="AdminMenu.jsp">Menu</a>
  <a href="LogoutAction.jsp">Log out</a>
</div>

<body>

	<%
		AdminInteraction con = (AdminInteraction) session.getAttribute("interaction");
		String anyErrors = request.getParameter("RemoveError");

		if (anyErrors != null && anyErrors.equals("0")) {
			out.println("School to remove does not exist in the database");
		} else if (anyErrors != null && anyErrors.equals("-1")) {
			out.println("This school cannot be removed because it has emphases or it has been saved by a user");
		}
	%>
<br>
<br>
	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="2" class="center">
		<tbody>
			<tr align="center">

				<td colspan="17" rowspan="1" style="vertical-align: top;"><a
					href="AddUniversity.jsp">ADD A NEW UNIVERSITY</a></td>

			</tr>
			<tr>
				<td style="vertical-align: top;">&nbsp;&nbsp;&nbsp;</td>
				<td style="vertical-align: top;">School</td>
				<td style="vertical-align: top;">State</td>
				<td style="vertical-align: top;">Location</td>
				<td style="vertical-align: top;">Control</td>
				<td style="vertical-align: top;"># Students</td>
				<td style="vertical-align: top;">% Female</td>
				<td style="vertical-align: top;">SAT Verbal</td>
				<td style="vertical-align: top;">SAT Math</td>
				<td style="vertical-align: top;">Expenses</td>
				<td style="vertical-align: top;">% Financial Aid</td>
				<td style="vertical-align: top;"># Applicants</td>
				<td style="vertical-align: top;">% Admitted</td>
				<td style="vertical-align: top;">% Enrolled</td>
				<td style="vertical-align: top;">Academic Scale(1-5)</td>
				<td style="vertical-align: top;">Social Scale(1-5)</td>
				<td style="vertical-align: top;">Quality of Life(1-5)</td>
				<td style="vertical-align: top;">&nbsp;&nbsp;&nbsp;</td>
			</tr>


			<%
				ArrayList<University> schools = con.viewSchoolList();
				for (int i = 0; i < schools.size(); i++) {
			%>
			<tr>
				<td style="vertical-align: top;">
					<form method="post" action="RemoveUniversity.jsp"
						name="Remove University">
						<input name="RemoveUniversity" value="Remove" type="submit">
						<input name="universityName" value="<%=schools.get(i).getName()%>"
							type="hidden">
					</form>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getName());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getState());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getLocation());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getControl());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getEnrollment());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getPercentFemale());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getSatVerbal());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getSatMath());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getCost());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getPercentFinAid());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getApplicants());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getPercentAdmitted());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getPercentEnrolled());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getAcademicScale());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getSocialScale());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schools.get(i).getQualityOfLife());
					%>
				</td>

				<td style="vertical-align: top;">
					<form method="post" action="EditUniversity.jsp"
						name="Edit University">
						<input name="Edit" value="Edit" type="submit"> <input
							name="universityName" value="<%=schools.get(i).getName()%>"
							type="hidden">
					</form>
				</td>

			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<br>
	</form>
	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="2">
		<tbody>
		</tbody>
	</table>
	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="2">
		<tbody>
		</tbody>
	</table>
	<br>
	<br>

</body>
</html>




























