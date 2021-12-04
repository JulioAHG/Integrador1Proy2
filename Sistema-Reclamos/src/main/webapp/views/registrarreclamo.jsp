<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electro Hogar  | Portada</title>
        <style>@import"css/estilos.css";</style>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <script src="https://use.fontawesome.com/d0255d9c7d.js"></script>
        <link rel="shortcut icon" href="images/electro_hogar_icono.ico" type="image/x-icon">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class='contenedor'>
<center><h3>Registrar Reclamo</h3></center>

<form method="post" action="reclamo" class="formulario_registro">
	<input type="hidden" name="opcion" value="guardar" />
	
	<label>Nombre:</label>
	<input type="text" name="nombre" /><br>
	<label>Apellido:</label>
	<input type="text" name="apellido" /><br>
	<label>DNI:</label>
	<input type="text" name="dni" /><br>
	<label>Telefono:</label>
	<input type="number" name="telefono" /><br>
	<label>Correo:</label>
	<input type="mail" name="correo" /><br>
	<label>Usuario:</label>
	<input type="text" name="usuario" /><br>
	<label>Contraseña:</label>
	<input type="password" name="contrasenia" /><br>
	
	<input type="submit" value="guardar" /><br>
</form>

</body>
</html>