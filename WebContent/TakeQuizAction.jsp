<%@ page language="java" import="cmc.interaction.*, cmc.entity.*, cmc.functionality.*, java.util.*"%>
<%@include file="verifyLoginCMC.jsp" %>
<% 
String location = request.getParameter("Q1");
String characteristic = request.getParameter("Q2");
String control = request.getParameter("Q3");
String emphasis = request.getParameter("Q4");

StudentInteraction stud = (StudentInteraction) session.getAttribute("interaction");

out.println(location+" "+characteristic+" "+control+" "+emphasis);

ArrayList<University> results = stud.takeQuiz(location, characteristic, control, emphasis);

int numOfMatches = results.size();

if(numOfMatches > 0){
	for(int i = 0; i < numOfMatches; i++){
		out.println(results.get(i).getName());
	}
	request.getRequestDispatcher("ViewSearchResults.jsp").forward(request, response);
}else{
	response.sendRedirect("TakePersonalityQuiz.jsp?Error=-1");
}

%>