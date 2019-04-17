<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>

<% 
String u = request.getParameter("username");
String p = request.getParameter("password");
AccountInteraction interaction = new AccountInteraction();
int loginStatus = interaction.login(u, p);
if(loginStatus == 0)
{
	if(interaction.viewProfile(u).get(4).equals("a"))
	{
		interaction = new AdminInteraction();
		session.setAttribute("interaction", interaction);
		response.sendRedirect("AdminMenu.jsp?username="+u+"&password="+p);
	}
	if(interaction.viewProfile(u).get(4).equals("u"))
	{
		interaction = new StudentInteraction();
		session.setAttribute("interaction", interaction);
		response.sendRedirect("StudentMenu.jsp?username="+u+"&password="+p);
	}
	
}
else
{
	 response.sendRedirect("Login.jsp?Error="+loginStatus);
}
%>