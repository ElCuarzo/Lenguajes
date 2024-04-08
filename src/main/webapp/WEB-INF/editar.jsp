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
	<form action="/lenguajes/${lenguaje.id}" method="POST">
		<input type="hidden" name="_method" value="DELETE">
	    <button type="submit">Eliminar</button>
	</form>
	<a href="/lenguajes">Volver a la pagina principal</a>
	<form action="/lenguajes/${lenguaje.id}" method="POST">
	    <input type="hidden" name="_method" value="PUT">
        <label for="nombre">Nombre: (<c:out value="${lenguaje.nombre}"/>)</label>
        <input type="text" id="nombre" name="nombre" value="${lenguaje.nombre}">
        <br>
        <label for="creador">Creador: (<c:out value="${lenguaje.creador}"/>)</label>
        <input type="text" id="creador" name="creador" value="${lenguaje.creador}">
        <br>
        <label for="version">Versión: (<c:out value="${lenguaje.version}"/>)</label>
        <input type="number" id="version" name="version" step="0.1" value="${lenguaje.version}">
        <br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>