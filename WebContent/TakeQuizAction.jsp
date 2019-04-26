<%@ page language="java" import="cmc.interaction.*, cmc.functionality.*, java.util.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<% 
String location = request.getParameter("Q1");
String characteristic = request.getParameter("Q2");
String control = request.getParameter("Q3");
String emphasis = request.getParameter("Q4");

StudentInteraction stud = (StudentInteraction) session.getAttribute("interaction");

//q3 size -- MODIFY
if(control.equals("LARGE"))
{
	control = "STATE";
}
else if(control.equals("SEMI-LARGE"))
{
	control = "STATE";
}
else if(control.equals("-1"))
{
	control = "-1";
}
else if(control.equals("SEMI-SMALL"))
{
	control = "PRIVATE";
}
else if(control.equals("SMALL"))
{
	control = "PRIVATE";
}

//q4 emphasis
String[] searchList = {};
if(emphasis.equals("BUSINESS"))
{
	String[] emphasesList = {"ACCOUNTING", "BUSINESS-ADMINISTRATION", "BUSINESS-EDUCATION", "ECONOMICS",
			"COMMUNICATIONS", "COMMERCE", "MANAGEMENT", "MARKETING"};
	searchList = emphasesList;
}
else if(emphasis.equals("MEDICINE"))
{
	String[] emphasesList = {"BIOLOGY", "BIOMED", "CHEMISTRY", "HEALTH-MEDICINE", "HEALTH-PROFESSIONS",
			"HEALTH-SCIENCE", "MEDICAL-SCHOOL", "MEDICAL", "MEDICINE", "MOLECULAR-BIOLOGY", "NATURAL-SCIENCES",
			"NURSING", "PHARMACY", "PRE-MED"};
	searchList = emphasesList;
}
else if(emphasis.equals("ENGINEERING"))
{
	String[] emphasesList = {"APPLIED-SCIENCE", "ARCHITECTURE", "APPLIED-TECHNOLOGY", "ARTS-AND-SCIENCES",
			"CHEMICAL-ENGINEERING", "COMPUTER-SCIENCE", "ELECTRICAL-ENGINEERING", "ENGINEERING",
			"MATH", "MATH-AND-SCIENCE", "MECHANICAL-ENGINEERING", "PHYSICAL-SCIENCES", "PHYSICS"};
	searchList = emphasesList;
}
else if(emphasis.equals("MUSIC"))
{
	String[] emphasesList = {"ARTS-AND-HUMANITIES", "FINE-ARTS", "FINE-AND-PERFORMING-ARTS", "PERFORMING-ARTS",
			"MUSIC", "MUSIC-COMPOSITION", "MUSIC-EDUCATION", "MUSIC-PERFORMANCE"};
	searchList = emphasesList;
}
else if(emphasis.equals("EDUCATION"))
{
	String[] emphasesList = {"BUSINESS-EDUCATION", "EDUCATION", "MUSIC-EDUCATION", "TEACHER-EDUCATION"};
	searchList = emphasesList;
}
else if(emphasis.equals("LAW"))
{
	String[] emphasesList = {"GOVERNMENT", "INTERNATIONAL-AFFAIRS", "LAW", "PHILOSOPHY", "POLITICAL-SCIENCE",
			"PRE-LAW", "SOCIAL-SCIENCE", "SOCIAL-WORK"};
	searchList = emphasesList;
}
else if(emphasis.equals("ENGLISH"))
{
	String[] emphasesList = {"ARTS-AND-HUMANITIES", "ENGLISH", "HUMANITIES"};
	searchList = emphasesList;
}
else if(emphasis.equals("LIBERAL-ARTS"))
{
	String[] emphasesList = {"LIBERAL-ARTS"};
	searchList = emphasesList;
}
else if(emphasis.equals("-1"))
{
	String[] emphasesList = {};
	searchList = emphasesList;
}


out.println(location+" "+characteristic+" "+control+" "+searchList);

stud.takeQuiz(location, characteristic, control, searchList);

%>