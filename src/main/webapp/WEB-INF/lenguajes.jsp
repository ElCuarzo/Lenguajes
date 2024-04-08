<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Index</title>
</head>
<body>
	
	<h2>Lista de lenguajes:</h2>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Creador</th>
			<th>Versión</th>
			<th>Acciones</th>
		</tr>
				
		<tbody>
        <c:forEach items="${lenguaje}" var="lenguaje">
        <tr>
            <td><a href="/lenguajes/mostrar/${lenguaje.id}"><c:out value="${lenguaje.nombre}"/></a></td>
            <td><c:out value="${lenguaje.creador}"/></td>
            <td><c:out value="${lenguaje.version}"/></td>
            <td>
            	<form action="/lenguajes/${lenguaje.id}" method="POST">
	            	<input type="hidden" name="_method" value="DELETE">
	            	<button type="submit">Eliminar</button>
	            </form>
	            <form action="/lenguajes/editar/${lenguaje.id}" method="POST">
					<button type="submit">Editar</button>
				</form>
            </td>
        </tr>
        </c:forEach>
		</tbody>
		
	</table>
	
	<h2>Crear Nuevo Lenguaje :</h2>
    <form action="/lenguajes" method="POST">
        <label for="nombre">Nombre: </label>
        <input type="text" id="nombre" name="nombre" required>
        <br>
        <label for="creador">Creador: </label>
        <input type="text" id="creador" name="creador" required>
        <br>
        <label for="version">Versión: </label>
        <input type="number" id="version" name="version" step="0.1" required>
        <br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>