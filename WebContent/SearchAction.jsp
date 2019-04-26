<%@ page language="java" import="cmc.interaction.*,java.util.*,cmc.functionality.*, cmc.entity.*"%>
<%
StudentInteraction student = (StudentInteraction)session.getAttribute("interaction");
//Map<String,String[]> params = request.getParameterMap();
//for(String key: params.keySet()){
//out.print(key + " =**" + request.getParameter(key) + "**<br>");
//} 
String name  = request.getParameter("School");
String state = request.getParameter("State");
String location = request.getParameter("Loc");
String control = request.getParameter("Cont");
String numStudentsMin = request.getParameter("NumOfStudMin");
String numStudentsMax = request.getParameter("NumOfStudMax");
String percentFemaleMin = request.getParameter("PerFemMin");
String percentFemaleMax = request.getParameter("PerFemMax");
String SATVerbalMin = request.getParameter("SATVerbalMin");
String SATVerbalMax = request.getParameter("SATVerbalMax");
String SATMathMin = request.getParameter("SATMathMin");
String SATMathMax= request.getParameter("SATMathMax");
String expensesMin = request.getParameter("ExpMin");
String expensesMax = request.getParameter("ExpMax");
String PercentFinancialAidMin = request.getParameter("PerFinAidMin");
String percenetFinancialAidMax = request.getParameter("PerFinAidMax");
String numberApplicantsMin = request.getParameter("NumOfAppMin");
String numberApplicantsMax = request.getParameter("NumOfAppMax");
String percentAddmittedMin = request.getParameter("PerAdmMin");
String percentAdmittedMax = request.getParameter("PerAdmMax");
String percentEnrolledMin = request.getParameter("PerEnrMin");
String percentEnrolledMax= request.getParameter("PerEnrMax");
String academicScaleMin = request.getParameter("AccScMin");
String academicScaleMax = request.getParameter("AccScMax");
String socialScaleMin = request.getParameter("SocScMin");
String socialScaleMax = request.getParameter("SocScMax");
String qualityOfLifeMin = request.getParameter("QLScMin");
String qualityOfLifeMax = request.getParameter("QLScMax");
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
	request.getRequestDispatcher("ViewSearchResults.jsp").forward(request, response);
}else{
	
}


%>