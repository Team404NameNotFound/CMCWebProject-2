<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<%@ page errorPage = "ErrorHandlingAdmin.jsp" %>
<%

AdminInteraction inter = (AdminInteraction)session.getAttribute("interaction");
String fname  = request.getParameter("firstName");
String lName = request.getParameter("lastName");
String uName = request.getParameter("username");
String password = request.getParameter("password");
String type = request.getParameter("type");
String activation = request.getParameter("status");

inter.editProfile(uName, fname, password, lName, type, activation);
response.sendRedirect("ViewUsers.jsp");

%>