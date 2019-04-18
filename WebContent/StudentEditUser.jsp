<%@page language="java" import="cmc.interaction.*"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>
<%
String username = request.getParameter("username");

StudentInteraction student = (StudentInteraction) session.getAttribute("interaction");
String fName = student.viewProfile(username).get(0);
String lName = student.viewProfile(username).get(1);
String password = student.viewProfile(username).get(3);
String type = student.viewProfile(username).get(4);
String status = student.viewProfile(username).get(5);
%>
<body>
	<form action="EditUserAction.jsp?username="+<%=request.getParameter("username")%> name="editForm">
		<table style="text-align: left; width: 523px; height: 180px;"
			border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;">First Name<br>
					</td>
					<td style="vertical-align: top;"><input name="firstName" value=<%=student.viewProfile(username).get(0)%>><br>
					</td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Last Name<br>
					</td>
					<td style="vertical-align: top;"><input name="lastName" value=<%= student.viewProfile(username).get(1) %>><br>
					</td>
				</tr>
				<tr>
					<td style="vertical-align: top;">User Name<br>
					</td>
					<td style="vertical-align: top;"><input readonly="readonly"
						name="username" value=<%= student.viewProfile(username).get(2)%>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Password<br>
					</td>
					<td style="vertical-align: top;"><input name="password" value=<%= student.viewProfile(username).get(3)%>><br>
					</td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Account Type<br>
					</td>
					<td style="vertical-align: top;"><input readonly="readonly" name="type" value=<%= student.viewProfile(username).get(4) %>><br>
					</td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Activation Status<br>
					</td>
					<td style="vertical-align: top;"><input
						name="status" value=<%= student.viewProfile(username).get(5) %>><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;"><input name="reset"
						type="reset"><br></td>
					<td style="vertical-align: top;"><input name="submit"
						value="Submit Edit" type="submit"><br></td>
				</tr>
			</tbody>
		</table>
		<br>
	</form>
</body>
</html>

