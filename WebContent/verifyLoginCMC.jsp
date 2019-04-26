<%@ page language="java" import="cmc.interaction.AccountInteraction"%>

<%
AccountInteraction sessionUser = (AccountInteraction) session.getAttribute("interaction");

if(!sessionUser.getLoggedIn() || sessionUser == null )
{
	response.sendRedirect("Login.jsp?Error=-6");
	return;
}
%>
