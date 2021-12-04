<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>PORTADA</h1>
<x:set var="cliente" value="${cliente}"> </x:set>
<h4>Bienvenido ${cliente.nombreCliente} ${cliente.apellidoCliente}</h4>

<x:choose>
	<x:when test="${cliente.idCliente=='3'}">
		<a href='reclamo?opcion=todosreclamos'>Atender Reclamos</a>
		<a href='reclamo?opcion=seguimientoreclamo'>Reporte de Reclamos</a>        
    </x:when>
    <x:otherwise>
        <a href='cliente?opcion=registrarreclamo'>Registrar Reclamo</a>
<a href='reclamo?opcion=seguimientoreclamo'>Seguimiento Reclamo</a>
    </x:otherwise>
    </x:choose>


</body>
</html>