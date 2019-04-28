<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<%
	AdminInteraction interaction = (AdminInteraction) session.getAttribute("interaction");
	String fname = request.getParameter("firstname");
	String lname = request.getParameter("lastname");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String type = request.getParameter("type");
	try
	 {
	interaction.addUser(fname, lname, username, password, type);
	response.sendRedirect("ViewUsers.jsp");
	 }
	catch(Exception e)
	{
		response.sendRedirect("ViewUsers.jsp?Error="+e.getMessage());
		 }
%>