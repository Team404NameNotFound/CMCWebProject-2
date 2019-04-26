<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<%
AccountInteraction user = (AccountInteraction) session.getAttribute("interaction");
user.logout();
session.setAttribute("interaction", null);
response.sendRedirect("Login.jsp");
%>