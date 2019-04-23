<html>
<head>
<title></title>
</head>
<body>
	<%@page language="java" import="cmc.entity.*, cmc.functionality.*, cmc.interaction.*, java.util.*"%>
   <%
		StudentInteraction student = (StudentInteraction) session.getAttribute("interaction");
		Account studentAccount = student.getAccount();
		out.println("aCCOUNT="+studentAccount);
	%>
	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="2">
		<tbody>
			<tr align="center">

				<td colspan="8" rowspan="1" style="vertical-align: top;"><a
					href="studentMenu.jsp">BACK TO MENU</a></td>

			</tr>
			<%
				ArrayList<UserSavedSchool> savedSchools = new ArrayList<UserSavedSchool>();
				savedSchools = student.viewSavedSchools();
				out.println(savedSchools.size());
				for (int i = 0; i < savedSchools.size(); i++) {
			%>
			<tr>
				<td style="vertical-align: top;">
					<%
						out.println(savedSchools.get(i).getName());
					%>
				</td>
				<td style="vertical-align: top;">
					<form method="post" action="ViewSavedSchoolDetails.jsp"
						name="View">
						<input name="ViewSavedSchoolDetails" value="View"
							type="submit"> <input name="savedSchool"
							value="<%=savedSchools.get(i).getName()%>" type="hidden">
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>
