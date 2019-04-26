<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="cmc.interaction.*, cmc.entity.*,  java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>
<body>
	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="2">
		<tbody>
		</tbody>
	</table>
	<br>
	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="2">
		<tbody>
			<tr align="center">

				<td colspan="8" rowspan="1" style="vertical-align: top;"><a
					href="AddUniversity.jsp">Add a University</a></td>

			</tr>
		</tbody>
	</table>
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
	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="2">
		<tbody>
			<tr>
				<td style="vertical-align: top;">School<br>
				</td>
				<td style="vertical-align: top;">state<br>
				</td>
				<td style="vertical-align: top;">Location<br>
				</td>
				<td style="vertical-align: top;">Control<br>
				</td>
				<td style="vertical-align: top;"># Students<br>
				</td>
				<td style="vertical-align: top;">% Female<br>
				</td>
				<td style="vertical-align: top;">SAT Verabl<br>
				</td>
				<td style="vertical-align: top;">SAT Math<br>
				</td>
				<td style="vertical-align: top;">Expenses<br>
				</td>
				<td style="vertical-align: top;">% Financial Aid<br>
				</td>
				<td style="vertical-align: top;"># Applicants<br>
				</td>
				<td style="vertical-align: top;">% Admitted<br>
				</td>
				<td style="vertical-align: top;">% Enrolled<br>
				</td>
				<td style="vertical-align: top;">Academic Scale(1-5)<br>
				</td>
				<td style="vertical-align: top;">Social Scale(1-5)<br>
				</td>
				<td style="vertical-align: top;">Quality of Life(1-5)<br>
				</td>
				<td style="vertical-align: top;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<br>
				</td>
			</tr>
		</tbody>
	</table>
	<%
		AdminInteraction interaction = (AdminInteraction) session.getAttribute("interaction");
		ArrayList<University> schools = interaction.viewSchoolList();
		for (int i = 0; i < schools.size(); i++) {
	%>
	<form action="EditUniversity.jsp" name="school">
		<table style="text-align: left; width: 100%;" border="1"
			cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;"><%=schools.get(i).getName()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getState()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getLocation()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getControl()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getEnrollment()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getPercentFemale()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getSatVerbal()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getSatMath()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getCost()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getPercentFinAid()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getApplicants()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getPercentAdmitted()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getPercentEnrolled()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getAcademicScale()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getSocialScale()%><br></td>
					<td style="vertical-align: top;"><%=schools.get(i).getQualityOfLife()%><br></td>
					<td style="vertical-align: top;"><span
						style="font-family: Times New Roman, Times, serif;"><input
							name="Edit" value="Edit" type="submit"></span><br></td>
				</tr>
			</tbody>
		</table>
		<br>
	</form>
	<%
		}
	%>
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

 --%>
<%@page language="java" import="cmc.entity.*"
		import="cmc.functionality.*" import="cmc.interaction.*"
		import="java.util.ArrayList"%>
		
<html>
<head>
<title></title>
</head>
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

	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="2">
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




























