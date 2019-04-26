<%@page language="java" import="cmc.interaction.*,cmc.entity.*,cmc.functionality.*,java.util.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>

<%  
	AdminInteraction admin = (AdminInteraction)session.getAttribute("interaction");
%>
<body>
	<form action="AddUniversityAction.jsp" name="addForm">
		<table style="text-align: left; width: 523px; height: 180px;"
			border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;">University Name<br>
					</td>
					<td style="vertical-align: top;"><input name = "School"
						/><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">State<br>
					</td>
					<td style="vertical-align: top;"><input name = "State"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Location<br>
					</td>
					<td style="vertical-align: top;"><input name = "Loc"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Control<br>
					</td>
					<td style="vertical-align: top;"><input name = "Cont"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Students<br>
					</td>
					<td style="vertical-align: top;"><input name = "NumOfStud"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Female<br>
					</td>
					<td style="vertical-align: top;"><input name = "PerFem"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Verbal<br>
					</td>
					<td style="vertical-align: top;"><input name = "SATVerbal"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Math<br>
					</td>
					<td style="vertical-align: top;"><input name = "SATMath"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Expenses<br>
					</td>
					<td style="vertical-align: top;"><input name = "Exp"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Financial Aid<br>
					</td>
					<td style="vertical-align: top;"><input name = "PerFinAid"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Applicants<br>
					</td>
					<td style="vertical-align: top;"><input name = "NumOfApp"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Admitted<br>
					</td>
					<td style="vertical-align: top;"><input name = "PerAdm"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Enrolled<br>
					</td>
					<td style="vertical-align: top;"><input name = "PerEnr"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Academic Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name = "AccSc"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Social Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name = "SocSc"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Quality of Life Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name = "QLSc"
						><br></td>
				</tr>
				<%
				for (int i = 0; i < 8; i++){ %>
				<tr>
					<td style="vertical-align: top;"><%out.print("Emphases " + (i + 1)); %><br>
					</td>
					<td style="vertical-align: top;"><input name = "<%out.print("Emp" + i);%>"
						><br></td>
				</tr>
				<%} %>
					<td style="vertical-align: top;"><input name="reset"
						type="reset"><br></td>
					<td style="vertical-align: top;"><input name="submit"
						value="Submit" type="submit"><br></td>
				</tr>
			</tbody>
		</table>
		<br>
	</form>
	<%
	String anyErrors = request.getParameter("Error");
	
	if(anyErrors != null && anyErrors.equals("0"))
	{
		out.println("This school has already exist, please change to a different school name");
	}
	else if(anyErrors != null && anyErrors.equals("-1"))
	{
		out.println("School name cannot be empty");
	}
	else if(anyErrors != null && anyErrors.equals("-2"))
	{
		out.println("Number of students (enrollment) needs to be a positive integer");
	}
	else if(anyErrors != null && anyErrors.equals("-3"))
	{
		out.println("%Female between 0 - 100");
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
</body>
</html>
