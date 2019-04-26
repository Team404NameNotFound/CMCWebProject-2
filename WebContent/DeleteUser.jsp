<%@page language="java" import="cmc.interaction.*";%>

<%String uName = request.getParameter("username");
AdminInteraction con = (AdminInteraction)session.getAttribute("interaction");
out.println("delete user : " + uName);
con.toggleActivationStatus(uName);
response.sendRedirect("ViewUsers.jsp");
%>