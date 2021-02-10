<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<style>
.error {
	color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person Form</title>
</head>
<body>
	Bonjour ${ perso.nom }
	<br>
	<form:form modelAttribute="personne" action="personne" method="post">
		<form:label path="nom">nom</form:label>
		<form:input path="nom" />
		<form:errors path="nom" cssClass="error" />
		<br>
		<form:label path="prenom">prenom</form:label>
		<form:input path="prenom" />
		<form:errors path="prenom" cssClass="error" />
		<input type="submit" value="Ajouter" />
	</form:form>
	<a href="deconnect"> deconnexion </a>
</body>
</html>