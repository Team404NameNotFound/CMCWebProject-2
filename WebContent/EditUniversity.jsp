<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@page language="java" import="cmc.interaction.*,cmc.entity.*,cmc.functionality.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>
<%String universityName = request.getParameter("universityName");
	AdminInteraction afc = (AdminInteraction)session.getAttribute("interaction");
	ArrayList<University> universityList = afc.viewSchoolList();
	/*boolean found = false; */
	DBController dbCon = new DBController();
	University university = dbCon.getUniversity2(universityName);
	/* for(int i = 0; i < universityList.size() && found == false; i++){
		if (universityList.get(i).getName().equals(universityName)){
			university = universityList.get(i);
			found = true;
		}
	} */
%>
<body>
	<form action="EditUniversityAction.jsp" name="editForm">
		<table style="text-align: left; width: 523px; height: 180px;"
			border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;">University Name<br>
					</td>
					<td style="vertical-align: top;"><input name = "School"
						value=<%=university.getName() %> readonly/><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">State<br>
					</td>
					<td style="vertical-align: top;"><input name = "State"
						value=<%=university.getState() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Location<br>
					</td>
					<td style="vertical-align: top;"><input name = "Loc"
						value=<%= university.getLocation() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Control<br>
					</td>
					<td style="vertical-align: top;"><input name = "Cont"
						value=<%= university.getControl() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Students<br>
					</td>
					<td style="vertical-align: top;"><input name = "NumOfStud"
						value=<%=university.getEnrollment() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Female<br>
					</td>
					<td style="vertical-align: top;"><input name = "PerFem"
						value=<%=university.getPercentFemale()%>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Verbal<br>
					</td>
					<td style="vertical-align: top;"><input name = "SATVerbal"
						value=<%=university.getSatVerbal() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Math<br>
					</td>
					<td style="vertical-align: top;"><input name = "SATMath"
						value=<%= university.getSatMath() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Expenses<br>
					</td>
					<td style="vertical-align: top;"><input name = "Exp"
						value=<%=university.getCost() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Financial Aid<br>
					</td>
					<td style="vertical-align: top;"><input name = "PerFinAid"
						value=<%=university.getPercentFinAid() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Applicants<br>
					</td>
					<td style="vertical-align: top;"><input name = "NumOfApp"
						value=<%= university.getApplicants() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Admitted<br>
					</td>
					<td style="vertical-align: top;"><input name = "PerAdm"
						value=<%= university.getPercentAdmitted() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Enrolled<br>
					</td>
					<td style="vertical-align: top;"><input name = "PerEnr"
						value=<%= university.getPercentEnrolled() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Academic Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name = "AccSc"
						value=<%= university.getAcademicScale() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Social Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name = "SocSc"
						value=<%= university.getSocialScale() %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Quality of Life Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name = "QLSc"
						value=<%= university.getQualityOfLife() %>><br></td>
				</tr>
				<%String[] emphases = university.getEmphases();
				int i = 0;
				for (; i < emphases.length; i++){ %>
				<tr>
					<td style="vertical-align: top;"><%out.print("Emphases " + (i + 1)); %><br>
					</td>
					<td style="vertical-align: top;"><input name = <%out.print("Emp" + i);%>
						value=<% out.print(emphases[i]); %>><br></td>
				</tr>
				<%} for (; i < 8; i++){%>
				<tr>
					<td style="vertical-align: top;">Add Emphases<br>
					</td>
					<td style="vertical-align: top;"><input name = <%out.print("Emp" + i);%>
						value=""><br></td>
				</tr>
				<%} %>
				<tr>
					<td style="vertical-align: top;"><input name="reset"
						type="reset"><br></td>
					<td style="vertical-align: top;"><input name="submit"
						value="Submit Edit" type="submit"><br></td>
				</tr>
			</tbody>
		</table>
		<br>
	</form>
</body>
</html>
