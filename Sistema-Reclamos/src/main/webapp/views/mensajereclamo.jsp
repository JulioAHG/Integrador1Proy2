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
<x:set var="titulo" value="${msgtitulo}"> </x:set>
<x:set var="detalle" value="${msgdetalle}"> </x:set>
<h3>${titulo}</h3>
<br>
<h3>${detalle}</h3>
<br>
<tr><td><a href="cliente?opcion=inicio">Volver al Inicio</a></td></tr>
</body>
</html>