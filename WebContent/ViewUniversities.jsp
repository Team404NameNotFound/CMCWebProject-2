<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page language="java" import="cmc.interaction.*, cmc.entity.*,  java.util.*"%>
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
			<tr>
				<td style="vertical-align: top;"><br></td>
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
	AdminInteraction interaction = (AdminInteraction)session.getAttribute("interaction");
	ArrayList<University> schools = interaction.viewSchoolList();
	for(int i = 0; i < schools.size(); i++)
	{
	%>
	<form action="EditUniversity" name="school">
		<table style="text-align: left; width: 100%;" border="1"
			cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;"><br><%schools.get(i).getName(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getState(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getLocation(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getControl(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getEnrollment(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getPercentFemale(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getSatVerbal(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getSatMath(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getCost(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getPercentFinAid(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getApplicants(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getPercentAdmitted(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getPercentEnrolled(); %></td>
					<td style="vertical-align: top;"><br><%schools.get(i).getAcademicScale(); %><</td>
					<td style="vertical-align: top;"><br><%schools.get(i).getSocialScale(); %><</td>
					<td style="vertical-align: top;"><br><%schools.get(i).getQualityOfLife(); %><</td>
					<td style="vertical-align: top;"><span
						style="font-family: Times New Roman, Times, serif;"><input
							name="Submit" value="Submit" type="submit"></span><br></td>
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

