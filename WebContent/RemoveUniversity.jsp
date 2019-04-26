<%@page language="java" import="cmc.interaction.*,cmc.entity.*,cmc.functionality.*,java.util.*"%>

<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>
<%  String schoolToRemove = request.getParameter("universityName");
	AdminInteraction admin = (AdminInteraction)session.getAttribute("interaction");
	int removeResult = admin.removeUniversity(schoolToRemove);
	if(removeResult == 1){
		response.sendRedirect("ViewUniversities.jsp");
	}else{
		response.sendRedirect("ViewUniversities.jsp?RemoveError="+removeResult);
	}
%>
</html>
