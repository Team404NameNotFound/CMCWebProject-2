<%@ page language="java" import="cmc.interaction.AccountInteraction"%>

<%
AccountInteraction sessionUser = (AccountInteraction) session.getAttribute("interaction");

if(sessionUser == null || !sessionUser.getLoggedIn())
{
	response.sendRedirect("Login.jsp?Error=-6");
	return;
}
%>
