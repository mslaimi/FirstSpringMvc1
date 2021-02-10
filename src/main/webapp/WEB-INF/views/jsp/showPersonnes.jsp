<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Personnes</title>
</head>
<body>
	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" method="post">
		<input type="submit" value="Deconnection" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<h1>List of Persons (Private access)</h1>
	<table>
		<tr>
			<td><b>Nom</b></td>
			<td><b>Prenom</b></td>
		</tr>
		<c:forEach items="${ personnes }" var="elt">
			<tr>
				<td><c:out value="${ elt['nom']}" /></td>
				<td><c:out value="${ elt['prenom'] }" /></td>
			</tr>
		</c:forEach>
	</table>
	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" method="post">
		<input type="submit" value="Deconnection" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>