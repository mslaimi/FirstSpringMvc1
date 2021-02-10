<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Bonjour ${ perso.nom }
	<form:form modelAttribute="personne" action="personne" method="post">
		<form:label path="nom">nom</form:label>
		<form:input path="nom" />
		<form:errors path="nom" cssClass="error" />
		<form:label path="prenom">prénom</form:label>
		<form:input path="prenom" />
		<form:errors path="prenom" cssClass="error" />
		<input type="submit" value="Ajouter" />
	</form:form>
	<a href="deconnect"> déconnexion </a>
</body>
</html>