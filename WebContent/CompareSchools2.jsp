<%@ page language="java" import="cmc.interaction.*,  java.util.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<%@ page errorPage = "ErrorHandlingStudent.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compare Schools by Score</title>
<%
StudentInteraction stud = (StudentInteraction) session.getAttribute("interaction");

%>
</head>

<style>
<%@include file="styleCMC.css" %>
<%@include file="topNavBarStyle.css" %>
.chart div {
  font: 18px sans-serif;
  background-color: RED;
  text-align: right;
  padding: 30px;
  margin: 10px;
  color: white;
}
</style>

<div class="header">
  <h1>ChooseMyCollege</h1>
  <p>Compare Schools by Score</p>
</div>
<div class="topnav">
  <a href="StudentMenu.jsp">Menu</a>
  <a href="LogoutAction.jsp">Logout</a>
</div>
<br>
<br>
<div style="float: left; width: 50%">
<h3 style="text-align:center"> Average ACT Score</h3>
</div>
  <hr color=#000000 width=800px align="left">

<br>
<div class="chart">
<%
			ArrayList<String> schoolScores = stud.compareSchoolsByScore();
				for (int i = 0; i < schoolScores.size(); i++) {%>
<%-- 				<div style="width: 40px;"><%int pos = schoolScores.get(i).lastIndexOf(" "); --%>
<%-- 				out.println(schoolScores.get(i).substring(pos)); %></div> --%>
				
				<div style="width: <%int pos = schoolScores.get(i).lastIndexOf(" ");
				out.println(schoolScores.get(i).substring(pos)); %>;"> <%=schoolScores.get(i) %></div>

			<%}%>
</div>
</html>