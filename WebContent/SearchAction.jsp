<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*, cmc.entity.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<%
StudentInteraction student = (StudentInteraction)session.getAttribute("interaction");

String name  = request.getParameter("School");
out.println(name);
String state = request.getParameter("State");
String location = request.getParameter("Loc");
String control = request.getParameter("Cont");
String numStudentsMin = request.getParameter("NumOfStud");
String numStudentsMax = request.getParameter("NumOfStud");
String percentFemaleMin = request.getParameter("PerFem");
String percentFemaleMax = request.getParameter("PerFem");
String SATVerbalMin = request.getParameter("SATVerbal");
String SATVerbalMax = request.getParameter("SATVerbal");
String SATMathMin = request.getParameter("SATMath");
String SATMathMax= request.getParameter("SATMath");
String expensesMin = request.getParameter("Exp");
String expensesMax = request.getParameter("Exp");
String PercentFinancialAidMin = request.getParameter("PerFinAid");
String percenetFinancialAidMax = request.getParameter("PerFinAid");
String numberApplicantsMin = request.getParameter("NumOfApp");
String numberApplicantsMax = request.getParameter("NumOfApp");
String percentAddmittedMin = request.getParameter("PerAdm");
String percentAdmittedMax = request.getParameter("PerAdm");
String percentEnrolledMin = request.getParameter("PerEnr");
String percentEnrolledMax= request.getParameter("PerEnr");
String academicScaleMin = request.getParameter("AccSc");
String academicScaleMax = request.getParameter("AccSc");
String socialScaleMin = request.getParameter("SocSc");
String socialScaleMax = request.getParameter("SocSc");
String qualityOfLifeMin = request.getParameter("QLSc");
String qualityOfLifeMax = request.getParameter("QLSc");
ArrayList<String> emphases = new ArrayList<String>();
for(int i = 1; i < 9; i++){
	String emphTemp = request.getParameter("Emp" + i);
	if(emphTemp.length() >= 1){
		emphases.add(emphTemp);
	}
}
String[] emphasesArray = {};
if(!emphases.isEmpty()){
	emphasesArray = new String[emphases.size()];
	for(int j = 0; j < emphases.size(); j++){
		emphasesArray[j]  = emphases.get(j);
	}
}
out.println(name);
ArrayList<University> matches = student.fieldSearch(name, state, location, numStudentsMin, numStudentsMax,
		percentFemaleMin, percentFemaleMax, SATVerbalMin, SATVerbalMax, SATMathMin, SATMathMax,
		expensesMin, expensesMax, PercentFinancialAidMin, percenetFinancialAidMax, numberApplicantsMin,
		numberApplicantsMax, percentAddmittedMin, percentAdmittedMax, percentEnrolledMin,
		percentEnrolledMax, academicScaleMin, academicScaleMax, socialScaleMin, socialScaleMax,
		qualityOfLifeMin, qualityOfLifeMax, emphasesArray, control);

int numOfMatches = matches.size();

if(numOfMatches > 0){
	for(int i = 0; i < numOfMatches; i++){
		out.println(matches.get(i).getName());
	}
}
%>