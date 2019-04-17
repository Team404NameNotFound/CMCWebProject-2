<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>

<% 
String u = request.getParameter("username");
String p = request.getParameter("password");
<<<<<<< HEAD
AccountInteraction interaction;
interaction = new AccountInteraction();

int loginStatus = 0;
=======
AccountInteraction interaction = new AccountInteraction();
int loginStatus = interaction.login(u, p);
>>>>>>> b07108545e998fa78be9f4cfbe652e843daf2be9

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