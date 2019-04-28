<%@page language="java" import="cmc.entity.*"
		import="cmc.functionality.*" import="cmc.interaction.*"
		import="java.util.ArrayList"%>
<%@include file="verifyLoginCMC.jsp" %>
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
  <p>View Users </p>
</div>
<div class="topnav">
  <a class="active" href="AdminMenu.jsp">Menu</a>
  <a href="AdminMenu.jsp">Menu</a>
  <a href="LogoutAction.jsp">Log out</a>
</div>
<body>
	<%
		AdminInteraction con = (AdminInteraction) session.getAttribute("interaction");
	%>
	<br>
	<br>
	<% 
	String anyErrors = request.getParameter("Error");
	if(anyErrors != null)
	{
		out.println(anyErrors);
	}
	%>
	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="0">
		<tbody>
		
			<tr align="center">

				<td colspan="8" rowspan="1" style="vertical-align: top;"><a
					href="AddUser.jsp">ADD A USER</a></td>

			</tr>
			<tr>
				<td style="vertical-align: top;">Edit</td>
				<td style="vertical-align: top; text-align: center;">Full name
				</td>
				<td style="vertical-align: top; text-align: center;">Username</td>
				<td style="vertical-align: top; text-align: center;">Password</td>
				<td style="vertical-align: top; text-align: center;">Type</td>
				<td style="vertical-align: top; text-align: center;">Status</td>
				<td style="vertical-align: top;">Toggle Activation Status</td>
			</tr>


			<%
				ArrayList<Account> allUsers = con.viewUsers();
				for (int i = 0; i < allUsers.size(); i++) {
			%>
			<tr>
				<td style="vertical-align: top;">
					<form method="post" action="AdminEditUser.jsp" name="Edit">
						<input name="Edit" value="Edit" type="submit"> <input
							name="username" value="<%=allUsers.get(i).getUsername()%>"
							type="hidden">
					</form>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(allUsers.get(i).getFirstName() + " " + allUsers.get(i).getLastName());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(allUsers.get(i).getUsername());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(allUsers.get(i).getPassword());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(allUsers.get(i).getUserType());
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(allUsers.get(i).getUserStatus());
					%>
				</td>
				<td style="vertical-align: top;">
					<form method="post" action="ToggleActivationStatusAction.jsp"
						name="Toggle Activation Status">
						<input name="Toggle" value="Toggle Activation Status"
							type="submit"> <input name="username"
							value="<%=allUsers.get(i).getUsername()%>" type="hidden">
					</form>
				</td>
			</tr>
			<%}%>
		</tbody>
	</table>
</body>
</html>
