<%@page language="java"
	import="cmc.interaction.*,cmc.entity.*,cmc.functionality.*,java.util.*"%>
<%@include file="verifyLoginCMC.jsp"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>
<style>
<%@include file="styleCMC.css" %>
<%@include file="topNavBarStyle.css" %>
</style>
 <div class="header">
  <h1>ChooseMyCollege</h1>
  <p>Edit University </p>
</div>
<div class="topnav">
  <a href="AdminMenu.jsp">Menu</a>
  <a href="LogoutAction.jsp">Log out</a>
</div>
 <br>
 <br>

<%
	String uniName = request.getParameter("universityName"); //from viewUniversities
	if(uniName==null) uniName = request.getParameter("School");  //from the original form
	AdminInteraction afc = (AdminInteraction)session.getAttribute("interaction");
	ArrayList<University> universityList = afc.viewSchoolList();
	boolean found = false; 
	DBController dbCon = new DBController();
	University university = dbCon.getUniversity2(uniName);
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
		out.println("%Female between 0-100" );
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
			border="1" cellpadding="2" cellspacing="2"
			class="center">
			<tbody>
				<tr>
					<td style="vertical-align: top;">University Name<br>
					</td>
					<td style="vertical-align: top;"><input name="School"
						<%-- value=<%=university.getName() %> --%> 
					value="<%out.println(uniName);%>"
						readonly /><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">State<br>
					</td>
					<td style="vertical-align: top;"><input name="State"
						value="<%=university.negOneStripper(university.getState())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Location<br>
					</td>
					<td style="vertical-align: top;"><input name="Loc"
						value="<%=university.negOneStripper(university.getLocation())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Control<br>
					</td>
					<td style="vertical-align: top;"><input name="Cont"
						value="<%=university.negOneStripper(university.getControl())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Students<br>
					</td>
					<td style="vertical-align: top;"><input name="NumOfStud"
						value="<%=university.negOneStripper(university.getEnrollment())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Female<br>
					</td>
					<td style="vertical-align: top;"><input name="PerFem"
						value="<%=university.negOneStripper(university.getPercentFemale())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Verbal<br>
					</td>
					<td style="vertical-align: top;"><input name="SATVerbal"
						value="<%=university.negOneStripper(university.getSatVerbal())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Math<br>
					</td>
					<td style="vertical-align: top;"><input name="SATMath"
						value="<%=university.negOneStripper(university.getSatMath())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Expenses<br>
					</td>
					<td style="vertical-align: top;"><input name="Exp"
						value="<%=university.negOneStripper(university.getCost())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Financial Aid<br>
					</td>
					<td style="vertical-align: top;"><input name="PerFinAid"
						value="<%=university.negOneStripper(university.getPercentFinAid())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Applicants<br>
					</td>
					<td style="vertical-align: top;"><input name="NumOfApp"
						value="<%=university.negOneStripper(university.getApplicants())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Admitted<br>
					</td>
					<td style="vertical-align: top;"><input name="PerAdm"
						value="<%=university.negOneStripper(university.getPercentAdmitted())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Enrolled<br>
					</td>
					<td style="vertical-align: top;"><input name="PerEnr"
						value="<%=university.negOneStripper(university.getPercentEnrolled())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Academic Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="AccSc"
						value="<%=university.negOneStripper(university.getAcademicScale())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Social Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="SocSc"
						value="<%=university.negOneStripper(university.getSocialScale())%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Quality of Life Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="QLSc"
						value="<%=university.negOneStripper(university.getQualityOfLife())%>"><br></td>
				</tr>
				<%String[] emphases = university.getEmphases();
				int i = 0;
				if(emphases.length > 0){
				for (; i < emphases.length; i++){ %>
				<tr>
					<td style="vertical-align: top;">
						<%out.print("Emphases " + (i + 1)); %><br>
					</td>
					<td style="vertical-align: top;"><input
						name=<%out.print("Emp" + i);%>
						value="<% out.print(emphases[i]); %>"><br></td>
				</tr>
				<%}} for (; i < 8; i++){%>
				<tr>
					<td style="vertical-align: top;">Add Emphases<br>
					</td>
					<td style="vertical-align: top;"><input
						name=<%out.print("Emp" + i);%> value=""><br></td>
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
