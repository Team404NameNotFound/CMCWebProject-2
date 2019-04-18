<%@ page language="java" import="cmc.interaction.*, cmc.functionality.*, java.util.*"%>
<%
AdminInteraction sessionUser = (AdminInteraction) session.getAttribute("interaction");
String fName = request.getParameter("firstname");
String lName = request.getParameter("lastname");
String username = request.getParameter("username");
String password = request.getParameter("password");
String type = request.getParameter("type");
String status = request.getParameter("status");

sessionUser.addUser(fName, lName, username, password, type);

response.sendRedirect("ViewUsers.jsp?Username="+sessionUser.viewProfile(username).get(2));
%>