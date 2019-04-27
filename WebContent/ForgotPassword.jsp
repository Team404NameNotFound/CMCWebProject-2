<%@ page language="java" import="cmc.interaction.AccountInteraction, cmc.functionality.*, java.util.*"%>

<style>
<%@include file="styleCMC.css" %>
<%@include file="topNavBarStyle.css" %>
</style>

<div class="header">
  <h1>ChooseMyCollege</h1>
</div>

<form method="post" action="ForgotPasswordAction.jsp" name="Login">
		<br>
		<table style="text-align: left; width: 266px; height: 228px;"
			border="1" cellpadding="2" cellspacing="2"
			class="center">
			<tbody>
				<tr>
					<td style="vertical-align: top;">Email<br>
					</td>
					<td style="vertical-align: top;"><input name="username">
					</td>
				</tr>
				<td style="vertical-align: top;"><input value="Send Email"
					name="Log in" type="submit"></td>
				<td style="vertical-align: top;"><input value="Reset"
					name="Reset" type="reset"></td>
			</tbody>
		</table>
		<br>
	</form>
	
	<%
	String emailStatus = request.getParameter("emailStatus");
	if(emailStatus != null && emailStatus.equals("-5")){
		out.println("Email could not be sent, enter a valid email");
	}
	%>