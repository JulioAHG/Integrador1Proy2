<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Electro Hogar | Cambiar Contraseña</title>
</head>
<body>
<h1>Cambiar Contraseña</h1>
<form method='post' action='cliente'>
<input type="hidden" name="opcion" value="recuperar" />
	<label>Ingresa tu Correo Electronico</label><br>
	<input type="mail" name="correo" /><br>
	<input type="submit" value="Cambiar Contraseña" /><br>
</form>
</body>
</html>