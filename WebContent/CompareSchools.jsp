<%@ page language="java" import="cmc.interaction.*,  java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compare Schools by Score</title>
<%
StudentInteraction stud = (StudentInteraction) session.getAttribute("interaction");

%>
</head>
<body>
<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="2">
		<tbody>
			<tr>
				<td style="vertical-align: top;">School</td>
				<td style="vertical-align: top; text-align: center;">Average SAT Score
				</td>
			</tr>


			<%
			ArrayList<String> schoolScores = stud.compareSchoolsByScore();
				for (int i = 0; i < schoolScores.size(); i++) {
			%>
			<tr>
				<td style="vertical-align: top;">
					<%
						int pos = schoolScores.get(i).lastIndexOf(" ");
						out.println(schoolScores.get(i).substring(0, pos));
					%>
				</td>
				<td style="vertical-align: top;">
					<%
						out.println(schoolScores.get(i).substring(pos));
					%>
				</td>
			</tr>
			<%}%>
		</tbody>
	</table>
</body>
</html>