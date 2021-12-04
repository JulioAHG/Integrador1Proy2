<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Electro Hogar | Seguimiento a Todos los Reclamo</title>
<script src="https://use.fontawesome.com/d0255d9c7d.js"></script>
</head>
<body>
<h1>Seguimiento de Reclamo</h1>

<table>
<thead>
	<th>Tipo</th>
	<th>Sub Tipo</th>
	<th>Fecha de Creación</th>
	<th>Estado</th>
	<th>Acciones</th>
</thead>
<tbody>
	<x:forEach var="reclamo" items="${listareclamos}" >
	<tr>
	<td><x:out value="${reclamo.tipo}"></x:out></td>
	<td><x:out value="${reclamo.subtipo}"></x:out></td>
	<td><x:out value="${reclamo.created_at}"></x:out></td>
	<td>
	<x:choose>
	<x:when test="${reclamo.estado=='0'}">
        PENDIENTE
    </x:when>
    <x:when test="${reclamo.estado=='1'}">
        ATENDIDO
    </x:when>    
    <x:otherwise>
        RECHAZADO
    </x:otherwise>
    </x:choose>
	</td>
	<td><a href='reclamo?opcion=ver&id=${reclamo.idReclamo}'><i class="fas fa-eye"></i><i class="far fa-eye"></i></a></td>
	</tr>
	</x:forEach>
	
</tbody>
</table>
</body>
</html>