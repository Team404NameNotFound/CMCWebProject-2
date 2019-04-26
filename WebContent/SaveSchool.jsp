<%@page language="java" import="cmc.entity.*, cmc.functionality.*, cmc.interaction.*, java.util.*"%>

<%
StudentInteraction interaction = (StudentInteraction)session.getAttribute("interaction");
String uniToSave = request.getParameter("School");

interaction.saveSchool(uniToSave);

response.sendRedirect("StudentMenu.jsp");
%>