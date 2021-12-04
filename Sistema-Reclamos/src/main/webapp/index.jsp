<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MENU DE OPCIONES</title>
</head>
<body>

<h1>Menú de Opciones</h1>

<x:set var="msg" value="${msglogin}"> </x:set>
<h3>${msg}</h3>

<form method='post' action='cliente'>
	<input type="hidden" name="opcion" value="ingresar" />
	<label>Usuario:</label>
	<input type="text" name="usuario" /><br>
	<label>Contraseña:</label>
	<input type="password" name="contrasenia" /><br>
	<br><a href="cliente?opcion=crear">Crear Cuenta</a>
	<br><a href="cliente?opcion=recuperar">Recuperar Cuenta</a>
	<input type="submit" value="ingresar" /><br>
</form>



</body>
</html>