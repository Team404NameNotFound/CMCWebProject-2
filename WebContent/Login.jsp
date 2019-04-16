<%@ page language="java" import="cmc.interaction.AccountInteraction,java.util.*"%>




<html>
<head>

<title>Login Form</title>
</head>
<body>
	<br> Login form:
	<br>
	<br>
	<form method="post" action="LoginAction.jsp" name="Login">
		<br>
		<table style="text-align: left; width: 266px; height: 228px;"
			border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;">Username<br>
					</td>
					<td style="vertical-align: top;"><input name="username">
					</td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Password<br>
					</td>
					<td style="vertical-align: top;"><input name="password">
					</td>
				</tr>

				<td style="vertical-align: top;"><input value="Log in"
					name="Log in" type="submit"></td>
				<td style="vertical-align: top;"><input value="Reset"
					name="Reset" type="reset"></td>
				</tr>
			</tbody>
		</table>
		<br>
	</form>
	<%
	String anyErrors = request.getParameter("Error");
	if(anyErrors != null && anyErrors.equals("-1"))
	{
		out.println("Please provide a valid username");
	}
	else if(anyErrors != null && anyErrors.equals("-2"))
	{
		out.println("Please provide a valid password");
	}
	else if(anyErrors != null && anyErrors.equals("-3"))
	{
		out.println("There was an error while attempting to access the database");
	}
	else if(anyErrors != null && anyErrors.equals("-4"))
	{
		out.println("You cannot use this function because you are not logged in");
	}
	
	%>
	<br>
</body>
</html>