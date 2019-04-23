<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>

<%

AdminInteraction adminInteraction = (AdminInteraction)session.getAttribute("interaction");
String name  = request.getParameter("School");
String state = request.getParameter("State");
String location = request.getParameter("Loc");
String control = request.getParameter("Cont");
String enrollment = request.getParameter("NumOfStud");
String percentFemale = request.getParameter("PerFem");
String satVerbal = request.getParameter("SATVerbal");
String satMath = request.getParameter("SATMath");
String cost = request.getParameter("Exp");
String percentFinAid = request.getParameter("PerFinAid");
String percentEnrolled = request.getParameter("PerEnr");
String applicants = request.getParameter("NumOfApp");
String percentAdmitted = request.getParameter("PerAdm");
String academicScale = request.getParameter("AccSc");
String socialScale = request.getParameter("SocSc");
String qualityOfLife = request.getParameter("QLSc");
String[] emphases = new String[8];
int j = 0;
for(int i = 0; i < 8; i++){
	String emphTemp = request.getParameter("Emp" + i);
	if(emphTemp != ""){
		emphases[j] = emphTemp;
		j++;
	}
}

adminInteraction.addNewUniversity(name, state, location, control, enrollment, percentFemale, satVerbal, satMath, cost, percentFinAid,
		percentEnrolled, applicants, percentAdmitted, academicScale, socialScale, qualityOfLife, emphases);
response.sendRedirect("ViewUniversities.jsp");

%>