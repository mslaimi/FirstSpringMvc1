<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connection Form</title>
</head>
<body>
	<form:form modelAttribute="perso" action="connect" method="post">
		<form:label path="nom">nom</form:label>
		<form:input path="nom" />
		<form:label path="prenom">prenom</form:label>
		<form:input path="prenom" />
		<input type="submit" value="Connection" />
	</form:form>
</body>
</html>
