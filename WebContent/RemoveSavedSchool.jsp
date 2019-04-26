<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*, cmc.entity.*"%>
<%
StudentInteraction interaction = (StudentInteraction)session.getAttribute("interaction");

String uniName = request.getParameter("savedSchool");

interaction.removeSavedSchool(uniName);
response.sendRedirect("StudentMenu.jsp");
%>