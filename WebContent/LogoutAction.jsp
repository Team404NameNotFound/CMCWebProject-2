<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<%
session.setAttribute("interaction", null);
response.sendRedirect("Login.jsp");
%>