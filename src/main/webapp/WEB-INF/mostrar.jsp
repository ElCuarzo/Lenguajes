<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<a href="/lenguajes">Volver a la pagina principal</a>
	<table>
		<tr>
			<th>Nombre: <c:out value="${lenguaje.nombre}"></c:out></th>
		</tr>
		<tr>
			<th>Creador: <c:out value="${lenguaje.creador}"></c:out></th>
		</tr>
		<tr>
			<th>Version: <c:out value="${lenguaje.version}"></c:out></th>
		</tr>
	</table>
	<form action="/lenguajes/editar/${lenguaje.id}" method="POST">
			<button type="submit">Editar</button>
	</form>
	<form action="/lenguajes/${lenguaje.id}" method="POST">
			<input type="hidden" name="_method" value="DELETE">
			<button type="submit">Eliminar</button>
	</form>
</body>
</html>