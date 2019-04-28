<%@page language="java" import="cmc.interaction.*,cmc.entity.*,cmc.functionality.*,java.util.*"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>

<style>
<%@include file="styleCMC.css" %>
<%@include file="topNavBarStyle.css" %>
</style>

<%  
	StudentInteraction student = (StudentInteraction)session.getAttribute("interaction");
%>

<div class="header">
  <h1>ChooseMyCollege</h1>
  <p>Search</p>
</div>
<div class="topnav">
  <a href="StudentMenu.jsp">Menu</a>
  <a href="LogoutAction.jsp">Logout</a>
</div>
<br>
<br>

<body>
	<form action="SearchAction.jsp" name="SearchMenu">
		<table style="text-align: left; width: 960px; height: 180px;"
			border="1" cellpadding="2" cellspacing="2"
			class="center">
			<tbody>
				<tr>
					<td style="vertical-align: top;">by SCHOOL NAME<br>
					</td>
					<td style="vertical-align: top;">contains<input name = "School"
						/><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by STATE<br>
					</td>
					<td style="vertical-align: top;">contains<input name = "State"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by LOCATION<br>
					</td>
					<td style="vertical-align: top;"><input name = "Loc"
						>(SUBURBAN, URBAN, SMALL-CITY or -1 for UNKNOWN)<br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by CONTROL<br>
					</td>
					<td style="vertical-align: top;"><input name = "Cont"
						>(PRIVATE, STATE, CITY or -1 for UNKNOWN)<br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by NUMBER OF STUDENTS<br>
					</td>
					<td style="vertical-align: top;">between<input name = "NumOfStudMin"
						>and<input name = "NumOfStudMax"
						> <br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by % FEMALE<br>
					</td>
					<td style="vertical-align: top;">between<input name = "PerFemMin"
						>and<input name = "PerFemMax"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by SAT VERBAL<br>
					</td>
					<td style="vertical-align: top;">between<input name = "SATVerbalMin"
						>and<input name = "SATVerbalMax"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by SAT MATH<br>
					</td>
					<td style="vertical-align: top;">between<input name = "SATMathMin"
						>and<input name = "SATMathMax"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by EXPENSES<br>
					</td>
					<td style="vertical-align: top;">between<input name = "ExpMin"
						>and<input name = "ExpMax"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by % FINANCIAL AID<br>
					</td>
					<td style="vertical-align: top;">between<input name = "PerFinAidMin"
						>and<input name = "PerFinAidMax"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by NUMBER OF APPLICANTS<br>
					</td>
					<td style="vertical-align: top;">between<input name = "NumOfAppMin"
						>and<input name = "NumOfAppMax"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by % ADMITTED<br>
					</td>
					<td style="vertical-align: top;">between<input name = "PerAdmMin"
						>and<input name = "PerAdmMax"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by % ENROLLED<br>
					</td>
					<td style="vertical-align: top;">between<input name = "PerEnrMin"
						>and<input name = "PerEnrMax"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by ACADEMICS SCALE (1-5)<br>
					</td>
					<td style="vertical-align: top;">between<input name = "AccScMin"
						>and<input name = "AccScMax"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by SOCAIL SCALE (1-5)<br>
					</td>
					<td style="vertical-align: top;">between<input name = "SocScMin"
						>and<input name = "SocScMax"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by QUALITY OF LIFE SCALE (1-5)<br>
					</td>
					<td style="vertical-align: top;">between<input name = "QLScMin"
						>and<input name = "QLScMax"
						><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by EMPHASES<br>
					</td>
					<td style="vertical-align: top;">contains either<br>	
				<input name = "Emp1"><br>
				<input name = "Emp2"><br>
				<input name = "Emp3"><br>
				<input name = "Emp4"><br>
				<input name = "Emp5"><br>
				<input name = "Emp6"><br>
				<input name = "Emp7"><br>
				<input name = "Emp8"><br>
						</td>
				</tr>
				
					<td style="vertical-align: top;"><input name="reset"
						type="reset"><br></td>
					<td style="vertical-align: top;"><input name="submit"
						value="Search For Schools" type="submit"><br></td>
				</tr>
			</tbody>
		</table>
		<br>
	</form>
	<% 
	%>
</body>
</html>
