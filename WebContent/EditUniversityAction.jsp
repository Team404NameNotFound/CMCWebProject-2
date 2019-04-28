<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*"%>
<html>
<%@include file="verifyLoginCMC.jsp" %>
<%@ page errorPage = "ErrorHandlingAdmin.jsp" %>
</html>

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

int editStatus = adminInteraction.editUniversityInfo(name, state, location, control, enrollment,
		percentFemale, satVerbal, satMath, cost, percentFinAid, applicants,
		percentAdmitted,percentEnrolled, academicScale, socialScale, qualityOfLife, emphasesArray);
if(editStatus == 1){
	response.sendRedirect("ViewUniversities.jsp?");
}else{
	request.getRequestDispatcher("EditUniversity.jsp?Error="+editStatus).forward(request, response);
}

%>