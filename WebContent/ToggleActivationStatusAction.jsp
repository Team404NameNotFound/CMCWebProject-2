<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>

<%

AdminInteraction inter = (AdminInteraction)session.getAttribute("interaction");
String uName = request.getParameter("username");

inter.toggleActivationStatus(uName);
response.sendRedirect("ViewUsers.jsp?username=");

%>

