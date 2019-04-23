<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>
<%
	AdminInteraction interaction = (AdminInteraction) session.getAttribute("interaction");
	String fname = request.getParameter("firstname");
	String lname = request.getParameter("lastname");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String type = request.getParameter("type");
	interaction.addUser(fname, lname, username, password, type);
	response.sendRedirect("ViewUsers.jsp");
%>