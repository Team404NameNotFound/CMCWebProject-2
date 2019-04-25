<%@page language="java" import="cmc.interaction.*,cmc.entity.*,cmc.functionality.*,java.util.*"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>

<%//String universityName = request.getParameter("school");
	String universityName = request.getParameter("universityName");
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
<%
	String anyErrors = request.getParameter("Error");
	if(anyErrors != null && anyErrors.equals("-1"))
	{
		out.println("School name cannot be empty");
	}
	else if(anyErrors != null && anyErrors.equals("-2"))
	{
		out.println("Number of students (enrollment) needs to be a positive integer");
	}
	else if(anyErrors != null && anyErrors.equals("-3"))
	{
		out.println("Helllo" + request.getParameter("UniName"));
	}
	else if(anyErrors != null && anyErrors.equals("-4"))
	{
		out.println("SAT Verbal between 200 - 800");
	}
	else if(anyErrors != null && anyErrors.equals("-5"))
	{
		out.println("SAT Math between 200 - 800");
	}
	else if(anyErrors != null && anyErrors.equals("-6"))
	{
		out.println("Expense must be positive");
	}
	else if(anyErrors != null && anyErrors.equals("-7"))
	{
		out.println("%FinAid between 0 - 100");
	}
	else if(anyErrors != null && anyErrors.equals("-8"))
	{
		out.println("Number of applicants needs to be a positive integer");
	}
	else if(anyErrors != null && anyErrors.equals("-9"))
	{
		out.println("%Admitted between 0 - 100");
	}
	else if(anyErrors != null && anyErrors.equals("-10"))
	{
		out.println("%Enrolled between 0 - 100");
	}
	else if(anyErrors != null && anyErrors.equals("-11"))
	{
		out.println("Adademic/Social/Life score among 1, 2, 3, 4, 5");
	}
	%>
	<form action="EditUniversityAction.jsp" name="editForm">
		<table style="text-align: left; width: 523px; height: 180px;"
			border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;">University Name<br>
					</td>
					<td style="vertical-align: top;"><input name = "School"
					<%-- value=<%=university.getName() %> --%> 
					value="<%out.println(universityName);%>" 
					readonly /><br></td> 
				</tr>
				<tr>
					<td style="vertical-align: top;">State<br>
					</td>
					<td style="vertical-align: top;"><input name = "State"
						value="<%=university.getState() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Location<br>
					</td>
					<td style="vertical-align: top;"><input name = "Loc"
						value="<%= university.getLocation() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Control<br>
					</td>
					<td style="vertical-align: top;"><input name = "Cont"
						value="<%= university.getControl() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Students<br>
					</td>
					<td style="vertical-align: top;"><input name = "NumOfStud"
						value="<%=university.getEnrollment() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Female<br>
					</td>
					<td style="vertical-align: top;"><input name = "PerFem"
						value="<%=university.getPercentFemale()%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Verbal<br>
					</td>
					<td style="vertical-align: top;"><input name = "SATVerbal"
						value="<%=university.getSatVerbal() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Math<br>
					</td>
					<td style="vertical-align: top;"><input name = "SATMath"
						value="<%= university.getSatMath() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Expenses<br>
					</td>
					<td style="vertical-align: top;"><input name = "Exp"
						value="<%=university.getCost() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Financial Aid<br>
					</td>
					<td style="vertical-align: top;"><input name = "PerFinAid"
						value="<%=university.getPercentFinAid() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Applicants<br>
					</td>
					<td style="vertical-align: top;"><input name = "NumOfApp"
						value="<%= university.getPercentEnrolled() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Admitted<br>
					</td>
					<td style="vertical-align: top;"><input name = "PerAdm"
						value="<%= university.getPercentAdmitted() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Enrolled<br>
					</td>
					<td style="vertical-align: top;"><input name = "PerEnr"
						value="<%= university.getApplicants() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Academic Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name = "AccSc"
						value="<%= university.getAcademicScale() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Social Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name = "SocSc"
						value="<%= university.getSocialScale() %>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Quality of Life Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name = "QLSc"
						value="<%= university.getQualityOfLife() %>"><br></td>
				</tr>
				<%String[] emphases = university.getEmphases();
				int i = 0;
				if(emphases.length > 0){
				for (; i < emphases.length; i++){ %>
				<tr>
					<td style="vertical-align: top;"><%out.print("Emphases " + (i + 1)); %><br>
					</td>
					<td style="vertical-align: top;"><input name = <%out.print("Emp" + i);%>
						value="<% out.print(emphases[i]); %>"><br></td>
				</tr>
				<%}} for (; i < 8; i++){%>
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
