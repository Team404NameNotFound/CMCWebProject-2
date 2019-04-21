<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title>Welcome Admin: <%out.println(request.getParameter("username")); %>> <br></title>
</head>
<body>
<a href="ViewUser.jsp">Manage Users</a><br>
<a href="ViewUniversity.jsp">Manage Universities</a><br>
</body>
</html>
