<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@page language="java" import="cmc.interaction.*,cmc.entity.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>
<%String universityName = request.getParameter("universityName");
	AdminInteraction afc = (AdminInteraction)session.getAttribute("interaction");
	ArrayList<University> universityList = afc.viewSchoolList();
	boolean found = false;
	University university = null;
	for(int i = 0; i < universityList.size() && found == false; i++){
		if (universityList.get(i).getName().equals(universityName)){
			university = universityList.get(i);
			found = true;
		}
	}
%>
<body>
	<form action="EditUserAction.jsp" name="editForm">
		<table style="text-align: left; width: 523px; height: 180px;"
			border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;">University Name<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getName(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">State<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getState(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Location<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getLocation(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Control<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getControl(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Students<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getEnrollment(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Female<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getPercentFemale(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Verbal<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getSatVerbal(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Math<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getSatMath(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Expenses<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getCost(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Financial Aid<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getPercentFinAid(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Applicants<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getApplicants(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Admitted<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getPercentAdmitted(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Enrolled<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getPercentEnrolled(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Academic Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getAcademicScale(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Social Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getSocialScale(); %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Quality of Life Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% university.getQualityOfLife(); %>><br></td>
				</tr>
				<%String[] emphases = university.getEmphases();
				for (int i = 0; i < emphases.length; i++){ %>
				<tr>
					<td style="vertical-align: top;"><%out.print("Emphases " + (i + 1)); %><br>
					</td>
					<td style="vertical-align: top;"><input
						name=<% out.print(emphases[i]); %>><br></td>
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
