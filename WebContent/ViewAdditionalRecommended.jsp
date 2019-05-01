<%@page language="java" import="cmc.entity.*"
		import="cmc.functionality.*" import="cmc.interaction.*"
		import="java.util.ArrayList"%>
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
  <p>School Details</p>
</div>
<div class="topnav">
  <a href="StudentMenu.jsp">Menu</a>
  <a href="LogoutAction.jsp">Logout</a>
</div>

<body>
	
	<%
	   StudentInteraction student = (StudentInteraction)session.getAttribute("interaction");
	   String matchSchool = request.getParameter("School");
	   ArrayList<String> matchDetails = student.viewSchoolDetails(matchSchool);
	   String[] matchEmphs = student.getSchoolEmphases(matchSchool);
	   String matchSavedTimes = student.viewUserSavedStatistics(matchSchool);   %>
	   
	   
	   <table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="0">
		<tbody>
			<%out.print("School information: "+matchSchool+"  "); %><form method="post" action="SaveSchool.jsp" name="SaveSchool">
						<input name="Save" value="Save" type="submit" class="button"> <input
							name="School" value="<%=matchSchool%>"
							type="hidden">
					</form>
			
			<tr>
					<td style="vertical-align: top;">University Name<br>
					</td>
					<td style="vertical-align: top;"><input name="School"
						<%-- value=<%=university.getName() %> --%> 
					value="<%=matchDetails.get(0)%>"
						readonly /><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">State<br>
					</td>
					<td style="vertical-align: top;"><input name="State"
						value="<%=matchDetails.get(1)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Location<br>
					</td>
					<td style="vertical-align: top;"><input name="Loc"
						value="<%=matchDetails.get(2)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Control<br>
					</td>
					<td style="vertical-align: top;"><input name="Cont"
						value="<%=matchDetails.get(3)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Students<br>
					</td>
					<td style="vertical-align: top;"><input name="NumOfStud"
						value="<%=matchDetails.get(4)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Female<br>
					</td>
					<td style="vertical-align: top;"><input name="PerFem"
						value="<%=matchDetails.get(5)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Verbal<br>
					</td>
					<td style="vertical-align: top;"><input name="SATVerbal"
						value="<%=matchDetails.get(6)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Math<br>
					</td>
					<td style="vertical-align: top;"><input name="SATMath"
						value="<%=matchDetails.get(7)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Expenses<br>
					</td>
					<td style="vertical-align: top;"><input name="Exp"
						value="<%=matchDetails.get(8)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Financial Aid<br>
					</td>
					<td style="vertical-align: top;"><input name="PerFinAid"
						value="<%=matchDetails.get(9)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Applicants<br>
					</td>
					<td style="vertical-align: top;"><input name="NumOfApp"
						value="<%=matchDetails.get(10)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Admitted<br>
					</td>
					<td style="vertical-align: top;"><input name="PerAdm"
						value="<%=matchDetails.get(11)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Enrolled<br>
					</td>
					<td style="vertical-align: top;"><input name="PerEnr"
						value="<%=matchDetails.get(12)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Academic Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="AccSc"
						value="<%=matchDetails.get(13)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Social Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="SocSc"
						value="<%=matchDetails.get(14)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Quality of Life Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="QLSc"
						value="<%=matchDetails.get(15)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Matching School User Saved Times<br>
					</td>
					<td style="vertical-align: top;"><input name="QLSc"
						value="<%=matchSavedTimes%>" readonly><br></td>
				</tr>

				<tr>
					<td style="vertical-align: top;">
						<%out.print("Emphases");%><br>
					</td>
					<td style="vertical-align: top;">
					<% for (int m= 0; m < matchEmphs.length; m++){ %><input
						name="Emp"+j) value="<% out.print(matchEmphs[m]); %>" readonly></br><%}%></td>
				</tr>
		</tbody>
	</table>
	   
	   
	   
	  <% ArrayList<University> recommends = student.findRecommended(matchSchool);
	   for (int i = 0; i < recommends.size(); i++) {
		   ArrayList<String> details = student.viewSchoolDetails(recommends.get(i).getName());
		   String[] emphs = student.getSchoolEmphases(recommends.get(i).getName());
		   String savedTimes = student.viewUserSavedStatistics(recommends.get(i).getName());
		   
	%>
	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="2">
		<tbody>
			<tr align="center">MAY WE ALSO RECOMMEND
			<form method="post" action="SaveSchool.jsp" name="SaveSchool">
						<input name="Save" value="Save" type="submit" class="button"> <input
							name="School" value="<%=recommends.get(i).getName()%>"
							type="hidden">
					</form>
			</tr>
			<tr>
					<td style="vertical-align: top;">University Name<br>
					</td>
					<td style="vertical-align: top;"><input name="School"
						<%-- value=<%=university.getName() %> --%> 
					value="<%=details.get(0)%>"
						readonly /><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">State<br>
					</td>
					<td style="vertical-align: top;"><input name="State"
						value="<%=details.get(1)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Location<br>
					</td>
					<td style="vertical-align: top;"><input name="Loc"
						value="<%=details.get(2)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Control<br>
					</td>
					<td style="vertical-align: top;"><input name="Cont"
						value="<%=details.get(3)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Students<br>
					</td>
					<td style="vertical-align: top;"><input name="NumOfStud"
						value="<%=details.get(4)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Female<br>
					</td>
					<td style="vertical-align: top;"><input name="PerFem"
						value="<%=details.get(5)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Verbal<br>
					</td>
					<td style="vertical-align: top;"><input name="SATVerbal"
						value="<%=details.get(6)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Math<br>
					</td>
					<td style="vertical-align: top;"><input name="SATMath"
						value="<%=details.get(7)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Expenses<br>
					</td>
					<td style="vertical-align: top;"><input name="Exp"
						value="<%=details.get(8)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Financial Aid<br>
					</td>
					<td style="vertical-align: top;"><input name="PerFinAid"
						value="<%=details.get(9)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Applicants<br>
					</td>
					<td style="vertical-align: top;"><input name="NumOfApp"
						value="<%=details.get(10)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Admitted<br>
					</td>
					<td style="vertical-align: top;"><input name="PerAdm"
						value="<%=details.get(11)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Enrolled<br>
					</td>
					<td style="vertical-align: top;"><input name="PerEnr"
						value="<%=details.get(12)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Academic Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="AccSc"
						value="<%=details.get(13)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Social Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="SocSc"
						value="<%=details.get(14)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Quality of Life Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="QLSc"
						value="<%=details.get(15)%>" readonly><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">User Saved Times<br>
					</td>
					<td style="vertical-align: top;"><input name="QLSc"
						value="<%=savedTimes%>" readonly><br></td>
				</tr>

				<tr>
					<td style="vertical-align: top;">
						<%out.print("Emphases");%><br>
					</td>
					<td style="vertical-align: top;">
					<% for (int j= 0; j < emphs.length; j++){ %><input
						name="Emp"+j) value="<% out.print(emphs[j]); %>" readonly></br><%}%></td>
				</tr>
			<%}%>
		</tbody>
	</table>
</body>
</html>
