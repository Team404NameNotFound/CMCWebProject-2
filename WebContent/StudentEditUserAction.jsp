<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<%

StudentInteraction inter = (StudentInteraction) session.getAttribute("interaction");
String fname  = request.getParameter("firstName");
String lName = request.getParameter("lastName");
String uName = request.getParameter("username");
String password = request.getParameter("password");
String type = request.getParameter("type");
String activation = request.getParameter("status");

inter.editProfile(uName, fname, lName, password, type, activation);
response.sendRedirect("StudentEditUser.jsp?message=-1");

%>