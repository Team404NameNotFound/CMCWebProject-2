<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@page language="java" import="cmc.interaction.*,cmc.entity.*,cmc.functionality.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
