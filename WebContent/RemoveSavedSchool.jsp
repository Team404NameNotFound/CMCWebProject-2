<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*, cmc.entity.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<%@ page errorPage = "ErrorHandlingStudent.jsp" %>
<%
StudentInteraction interaction = (StudentInteraction)session.getAttribute("interaction");

String uniName = request.getParameter("savedSchool");

interaction.removeSavedSchool(uniName);
response.sendRedirect("StudentMenu.jsp");
%>