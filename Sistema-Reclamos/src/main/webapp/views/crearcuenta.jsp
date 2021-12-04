<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electro Hogar  | Crear Cuenta</title>
        <style>@import"css/estilos.css";</style>
        <link rel="shortcut icon" href="../images/electro_hogar_icono.ico" type="image/x-icon">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body class="logincontainer" style="overflow-y:scroll;">

<form method="post" action="cliente" class="login">
<div>
	<center>
        <img src="images/electro_hogar_logo.jpg" style="max-height:100px;" >
        <br><label style='font-size:20px'>Crear Nueva Cuenta</label>
    </center>
    <br>
	<input type="hidden" name="opcion" value="guardar" />
	
	<div>
    	<div style="text-align:left;">Nombre:</div>
        <input type="text" name="nombre" class="input"/><br>
    </div><br>
    <div>
    	<div style="text-align:left;">Apellido:</div>
        <input type="text" name="apellido" class="input"/><br>
    </div>  <br>    
    <div>
    	<div style="text-align:left;">DNI:</div>
        <input type="number" name="dni" class="input"/><br>
    </div>  <br>   
    <div>
    	<div style="text-align:left;">Telefono:</div>
        <input type="number" name="telefono" class="input"/><br>
    </div>  <br>   
    <div>
    	<div style="text-align:left;">Correo:</div>
        <input type="mail" name="correo" class="input"/><br>
    </div>  <br>   
	<div>
    	<div style="text-align:left;">Usuario:</div>
        <input type="text" name="usuario" class="input"/><br>
    </div>  <br> 
    <div>
    	<div style="text-align:left;">Contraseña:</div>
        <input type="password" name="contrasenia" class="input"/><br>
    </div>  <br> 
	
	<input type="submit" class="btn_success"" value="GUARDAR" /><br><br>
	
	<div style="text-align:right;font-size:12px;">
		<a href='http://localhost:8080/Sistema-Reclamos/views/login.jsp' title="Volver al Login" class="azul" style="text-decoration:none;">Volver al Login</a><br><br>
    </div>
	</div>
</form>

</body>
</html>