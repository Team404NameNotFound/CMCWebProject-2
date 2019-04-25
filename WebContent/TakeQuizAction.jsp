<%@ page language="java" import="cmc.interaction.AccountInteraction, cmc.functionality.*, java.util.*"%>
<% 
String q1 = request.getParameter("Q1");
String q2 = request.getParameter("Q2");
String q3 = request.getParameter("Q3");
String q4 = request.getParameter("Q4");


out.println(q1+" "+q2+" "+q3+" "+q4);
%>