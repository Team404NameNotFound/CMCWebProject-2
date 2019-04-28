<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<%

AdminInteraction adminInteraction = (AdminInteraction)session.getAttribute("interaction");

 Map<String,String[]> params = request.getParameterMap();
for(String key: params.keySet()){
out.println(key + " =**" + request.getParameter(key) + "**<br>");
} 

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
String applicants = request.getParameter("NumOfApp");
String percentAdmitted = request.getParameter("PerAdm");
String percentEnrolled = request.getParameter("PerEnr");
String academicScale = request.getParameter("AccSc");
String socialScale = request.getParameter("SocSc");
String qualityOfLife = request.getParameter("QLSc");
//String[] emphases = new String[8];
ArrayList<String> emphases = new ArrayList<String>();
for(int i = 0; i < 8; i++){
	String emphTemp = request.getParameter("Emp" + i);
	if(emphTemp.length() >= 1){
		emphases.add(emphTemp);
	}
}
String[] emphasesArray = new String[emphases.size()];
for(int j = 0; j < emphases.size(); j++){
	emphasesArray[j]  = emphases.get(j);
}

int i = adminInteraction.addNewUniversity(name, state, location, control, enrollment,
		percentFemale, satVerbal, satMath, cost, percentFinAid, applicants,
		percentAdmitted,percentEnrolled, academicScale, socialScale, qualityOfLife, emphasesArray);

if(i == 0)
{
response.sendRedirect("ViewUniversities.jsp");
}
else 
{
	response.sendRedirect("ViewUniversities.jsp"+i);
}


%>