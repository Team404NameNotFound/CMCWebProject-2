<%@ page language="java" import="cmc.interaction.*,java.util.*"%>

    <% 
String u = request.getParameter("username");
String p = request.getParameter("password");
AccountInteraction interaction = (AccountInteraction) session.getAttribute("interaction");

int loginStatus = interaction.login(u, p);

if(loginStatus == 0)
{
	if(interaction.viewProfile(u).get(4).equals("a"))
	{
		interaction = (StudentInteraction) session.getAttribute("interaction");
		response.sendRedirect("AdminMenu.jsp");
	}
	if(interaction.viewProfile(u).get(4).equals("u"))
	{
		interaction = (AdminInteraction) session.getAttribute("interaction");
		response.sendRedirect("AdminMenu.jsp");
	}
	
}
else
{
	 response.sendRedirect("Login.jsp?Error="+loginStatus);
}



%>