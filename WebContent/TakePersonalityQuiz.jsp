<%@ page language="java" import="cmc.interaction.AccountInteraction, cmc.functionality.*, java.util.*"%>
<%@include file="verifyLoginCMC.jsp" %>

<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title></title>
</head>

<style>
<%@include file="styleCMC.css" %>
<%@include file="topNavBarStyle.css" %>
</style>

<div class="header">
  <h1>ChooseMyCollege</h1>
  <p>Personality Quiz </p>
</div>
<div class="topnav">
  <a href="StudentMenu.jsp">Menu</a>
  <a href="LogoutAction.jsp">Logout</a>
</div>
<br>
<% 
String anyErrors = request.getParameter("Error");
	
	if(anyErrors != null && anyErrors.equals("-1"))
	{
		%><p style="color:red">No matches found </p><%
	}
%>
<br>


<body text="white">
<div>
    <div style="float: left; width: 50%">

	<form method="post" action="TakeQuizAction.jsp" name="Quiz">
	<span style="font-weight: bold; color:#FED0C6">1. How would you describe the
		location of your ideal college?</span>
	<br>
	<input name="Q1" value="URBAN" type="radio" checked>Walking distance to
	many different restaurants, shops and exciting events
	<br>
	<input name="Q1" value="SMALL-CITY" type="radio">Surrounded by nature
	and tranquility
	<br>
	<input name="Q1" value="SUBURBAN" type="radio">A mixture of access
	to conveniences and peacefulness
	<br>
	<input name="Q1" value="-1" type="radio"> Location does not
	matter to me
	<br>
	<br>
	<span style="font-weight: bold; color:#FED0C6">2. Which characteristics are
		most important to you when looking for colleges?</span>
	<br>
	<input name="Q2" value="academic" type="radio" checked>Prestige and
	challenging classes
	<br>
	<input name="Q2" value="social" type="radio">Lots of parties and
	sporting events
	<br>
	<input name="Q2" value="qualityOfLife" type="radio">Good food and nice
	dorms
	<br>
	<br>
	<span style="font-weight: bold; color:#FED0C6">3. I prefer large lectures
		where I can observe and be anonymous, rather than small discussions
		with lots of participation and my professors know my name</span>
	<br>
	<input name="Q3" value="LARGE" type="radio" checked>Strongly disagree
	<br>
	<input name="Q3" value="SEMI-LARGE" type="radio">Disagree
	<br>
	<input name="Q3" value="-1" type="radio">Neutral
	<br>
	<input name="Q3" value="SEMI-SMALL" type="radio">Agree
	<br>
	<input name="Q3" value="SMALL" type="radio">Strongly Agree
	<br>
	<br>
	<span style="font-weight: bold; color:#FED0C6">4. What would you like to
		study?<br>
	</span>
	<input name="Q4" value="BUSINESS" type="radio" checked>Business or a related
	field
	<br>
	<input name="Q4" value="MEDICINE" type="radio">Medicine or a
	related field
	<br>
	<input name="Q4" value="ENGINEERING" type="radio">Engineering or a
	related field
	<br>
	<input name="Q4" value="MUSIC" type="radio">Music or a related
	field
	<br>
	<input name="Q4" value="EDUCATION" type="radio">Education or a
	related field
	<br>
	<input name="Q4" value="LAW" type="radio">Law or a related
	field
	<br>
	<input name="Q4" value="ENGLISH" type="radio">English or a related
	field
	<br>
	<input name="Q4" value="LIBERAL-ARTS" type="radio">Liberal arts
	<br>
	<input name="Q4" value="-1" type="radio">Unsure
	<br>
	<span style="font-weight: bold; color:#FED0C6"><br> </span>
	<div style="text-align:center">
		<input name="quizResults" value="Submit" type="submit" class="button"> <br>
	</div>
	</form>
	</div>
</div>
</body>
</html>