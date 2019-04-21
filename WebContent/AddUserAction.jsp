<%@page language="java" import="cmc.interaction.*"%>
<%@include file="verifyLogin.jsp" %>
<%
String firstname = request.getParameter("firstName");
String lastname = request.getParameter("lastName");
String username = request.getParameter("username");
String password = request.getParameter("password");
String type = request.getParameter("type");
String status = request.getParameter("status");

AdminInteraction ai = (AdminInteraction) session.getAttribute("interaction");
response.sendRedirect("AdminMenu.jsp?");
%>