<%@page language="java" import="cmc.interaction.*,cmc.entity.*,cmc.functionality.*,java.util.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>

<%//String universityName = request.getParameter("school");
	String universityName = request.getParameter("savedSchool");
	StudentInteraction afc = (StudentInteraction)session.getAttribute("interaction");
	ArrayList<String> university = afc.viewSchoolDetails(universityName);
%>
<body>
	<form action="EditUniversityAction.jsp" name="editForm">
		<table style="text-align: left; width: 523px; height: 180px;"
			border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;">University Name<br>
					</td>
					<td style="vertical-align: top;"><%=university.get(0)%><br></td> 
				</tr>
				<tr>
					<td style="vertical-align: top;">State<br>
					</td>
					<td style="vertical-align: top;"><%=university.get(1) %><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Location<br>
					</td>
					<td style="vertical-align: top;"><%=  university.get(2) %><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Control<br>
					</td>
					<td style="vertical-align: top;"><%= university.get(3)%><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Students<br>
					</td>
					<td style="vertical-align: top;"><%= university.get(4)%><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Female<br>
					</td>
					<td style="vertical-align: top;"><%=university.get(5)%><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Verbal<br>
					</td>
					<td style="vertical-align: top;"><%=university.get(6) %><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT Math<br>
					</td>
					<td style="vertical-align: top;"><%= university.get(7) %><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Expenses<br>
					</td>
					<td style="vertical-align: top;"><%= university.get(8)%><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Financial Aid<br>
					</td>
					<td style="vertical-align: top;"><%= university.get(9)%><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Number of Applicants<br>
					</td>
					<td style="vertical-align: top;"><%= university.get(10) %><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Admitted<br>
					</td>
					<td style="vertical-align: top;"><%= university.get(11) %><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% Enrolled<br>
					</td>
					<td style="vertical-align: top;"><%= university.get(12)  %><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Academic Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><%=university.get(13) %><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Social Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><%= university.get(14) %><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Quality of Life Scale(1-5)<br>
					</td>
					<td style="vertical-align: top;"><%=  university.get(15)%><br></td>
				</tr>
				<%
				for(int i = 16; i < university.size();i++)
				{
					%>
					<tr>
					<td style="vertical-align: top;">Emphases <%= i - 14 %><br>
					</td>
					<td style="vertical-align: top;"><%= university.get(i) %><br></td>
						</tr>
					<% 
				}
				%>

			</tbody>
		</table>
		<br>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>