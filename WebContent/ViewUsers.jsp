<html>
<head>
<title></title>
</head>
<body>
<%@page language="java" import="cmc.entity.*" import="cmc.functionality.*" import="cmc.interaction.*" import = "java.util.ArrayList"%>
<%AdminInteraction con = (AdminInteraction)session.getAttribute("interaction");%>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">

<td colspan="8" rowspan="1" style="vertical-align: top;"><a
href="Add.jsp">ADD A USER</a>
</td>

</tr>
<tr>
<td style="vertical-align: top;">
Edit</td>
<td style="vertical-align: top; text-align: center;">Full name
</td>
<td style="vertical-align: top; text-align: center;">Username
</td>
<td style="vertical-align: top; text-align: center;">Password
</td>
<td style="vertical-align: top; text-align: center;">Type
</td>
<td style="vertical-align: top; text-align: center;">Status
</td>
<td style="vertical-align: top;">Delete
</td>
</tr>


<%ArrayList<Account> allUsers = con.viewUsers();
for (int i = 0; i < allUsers.size(); i++ ){
%>
<tr>
<td style="vertical-align: top;">
<form method="post" action="Edit.jsp" name="Edit">
    <input name="Edit" value="Edit" type="submit">
    <input name="Username" value="<%=allUsers.get(i).getUsername()%>" type="hidden">
</form>
</td>
<td style="vertical-align: top;"><%out.println(allUsers.get(i).getFirstName() + " " + allUsers.get(i).getLastName());%>
</td>
<td style="vertical-align: top;"><%out.println(allUsers.get(i).getUsername());%>
</td>
<td style="vertical-align: top;"><%out.println(allUsers.get(i).getPassword());%>
</td>
<td style="vertical-align: top;"><%out.println(allUsers.get(i).getUserType());%>
</td>
<td style="vertical-align: top;"><%out.println(allUsers.get(i).getUserStatus());%>
</td>
<td style="vertical-align: top;">
<form method="post" action="Delete.jsp" name="Delete">
    <input name="Delete" value="Delete" type="submit">
    <input name="Username" value= "<%=allUsers.get(i).getUsername()%>" type="hidden">   
</form>
</td>
</tr>
<%}%>
</tbody>
</table>
</body>
</html>
