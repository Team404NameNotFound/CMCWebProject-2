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
<%@include file="styleCMC.css" %>
</style>


<body>
<div class="header">
  <h1>Welcome to ChooseMyCollege</h1>
  <p>Login:</p>
</div>
	<br>
	<p style="color:red" align=center>
	<%
	String anyErrors = request.getParameter("Error");
	if(anyErrors != null && anyErrors.equals("-6"))
	{
		out.println("You must login before accessing this page");
	} 
	
	
	String emailStatus = request.getParameter("emailStatus");
	if(emailStatus != null && emailStatus.equals("0"))
	{
		out.println("Email was successfully sent");
	}
	
	%>
	</p>
	<form method="post" action="LoginAction.jsp" name="Login">
		<br>
		<table style="text-align: left; width: 266px; height: 228px;"
			border="1" cellpadding="2" cellspacing="0" background="white"
			class="center">
			<tbody>
				<tr>
					<td style="vertical-align: center;"> Username<br>
					</td>
					<td style="vertical-align: center;"><input name="username">
					</td>
				</tr>
				<tr>
					<td style="vertical-align: center;">Password<br>
					</td>
					<td style="vertical-align: center;"><input name="password" type = "password">
					</td>
				</tr>
				<tr>
				<td style="vertical-align: center; style=text-align:center"><button class="button">Log in</button>
				<td style="vertical-align: center style=text-align:center"> <button value="reset" class="button">Reset</button>
				</tr>
			</tbody>
	<br>
		</table>
		<br>
	</form>
	<div style="text-align:center">    
  <a href="ForgotPassword.jsp"style="color:blue; text-align:center">Forgot password?</a>
</div>
</body>
</html>