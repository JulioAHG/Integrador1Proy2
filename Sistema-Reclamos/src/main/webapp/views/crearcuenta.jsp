<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Electro Hogar | Crear Cuenta</title>
</head>
<body>
<h1>Crear Cuenta</h1>

<form method="post" action="cliente">
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