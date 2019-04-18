<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>

<%

AdminInteraction inter = (AdminInteraction)session.getAttribute("interaction");
String fname  = request.getParameter("firstName");
String lName = request.getParameter("lastName");
String uName = request.getParameter("username");
String password = request.getParameter("password");
String type = request.getParameter("type");
String activation = request.getParameter("activationStatus");

inter.editProfile(uName, fname, lName, password, type);
response.sendRedirect("ViewUsers.jsp");

%>