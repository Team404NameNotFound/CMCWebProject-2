<%@ page language="java" import="cmc.interaction.AccountInteraction, cmc.functionality.*, java.util.*"%>
<% 
String q1 = request.getParameter("Q1");
String q2 = request.getParameter("Q2");
String q3 = request.getParameter("Q3");
String q4 = request.getParameter("Q4");

//q1 location
if(q1.equals("URBAN"))
{
	
}
else if(q1.equals("SMALL-CITY"))
{
	
}
else if(q1.equals("SUBURBAN"))
{
	
}
else if(q1.equals("-1"))
{
	
}
//q2 scales
if(q2.equals("ACADEMIC"))
{
	
}
else if(q2.equals("SOCIAL"))
{
	
}
else if(q2.equals("QUALITYOFLIFE"))
{
	
}
//q3 size
if(q3.equals("LARGE"))
{
	
}
else if(q3.equals("SEMI-LARGE"))
{
	
}
else if(q3.equals("-1"))
{
	
}
else if(q3.equals("SEMI-SMALL"))
{
	
}
else if(q3.equals("SMALL"))
{
	
}

//q4 emphases
if(q4.equals("BUSINESS"))
{
	
}
else if(q4.equals("MEDICINE"))
{
	
}
else if(q4.equals("ENGINEERING"))
{
	
}
else if(q4.equals("MUSIC"))
{
	
}
else if(q4.equals("EDUCATION"))
{
	
}
else if(q4.equals("LAW"))
{
	
}
else if(q4.equals("ENGLISH"))
{
	
}
else if(q4.equals("LIBERAL-ARTS"))
{
	
}
else if(q4.equals("-1"))
{
	
}

out.println(q1+" "+q2+" "+q3+" "+q4);
%>