<%@ page language="java" import="cmc.interaction.AccountInteraction, cmc.functionality.*, java.util.*"%>
<%@ page errorPage = "ErrorHandlingBeforeLogin.jsp" %>

<% String u = request.getParameter("username"); 

AccountInteraction user = (AccountInteraction) session.getAttribute("interaction");

int emailStatus = user.forgotPsw(u);
if(emailStatus == 0){
	response.sendRedirect("Login.jsp?emailStatus="+emailStatus);
}
else{
	response.sendRedirect("ForgotPassword.jsp?emailStatus="+emailStatus);
}



%>