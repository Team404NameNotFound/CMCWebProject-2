<%@ page language="java" import="cmc.interaction.*,  java.util.*"%>
<%
AccountInteraction user = new AccountInteraction();
session.setAttribute("interaction", user);
%>
<html>
<head>

<title>Login Form</title>
</head>
<style>
body {background-image: url("bookBackground.jpg");
  height: 500px;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;}
</style>


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
					<td style="vertical-align: top;"> Username<br>
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
				<tr>
				<td style="vertical-align: top;"><input value="Log in"
					name="Log in" type="submit"></td>
				<td style="vertical-align: top;"><input value="Reset"
					name="Reset" type="reset"></td>
				</tr>
			</tbody>
		</table>
		<br>
	</form>
	
	<br>
	<a href="ForgotPassword.jsp">Forgot password?</a>
	<br>
	<br>
	<br>
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
		out.println("User is inactive");
	}
	else if(anyErrors != null && anyErrors.equals("-4"))
	{
		out.println("User is already logged in");
	}
	 else if(anyErrors != null && anyErrors.equals("-6"))
	{
		out.println("You must login before accessing this page");
	} 
	
	
	String emailStatus = request.getParameter("emailStatus");
	if(emailStatus != null && emailStatus.equals("0"))
	{
		out.println("Email was successfully sent");
	}
	else if(anyErrors != null && anyErrors.equals("-5"))
	{
		out.println("Email could not be sent");
	}
	
	
	%>
	<br>
</body>
</html>