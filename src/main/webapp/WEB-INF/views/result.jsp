<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.ArrayList, org.eclipse.FirstSpringMvc.model.Personne" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show list</title>
</head>
<body>
	<%
	ArrayList<Personne> al = (ArrayList<Personne>) request.getAttribute("tab");
	for (Personne p : al) {
		out.print("Hello " + p.getNom() + " " + p.getPrenom());
		out.print("<br>");
	}
	%>
</body>
</html>