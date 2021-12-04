<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electro Hogar  | Crear Reclamo</title>
        <style>@import"css/estilos.css";</style>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <script src="https://use.fontawesome.com/d0255d9c7d.js"></script>
        <link rel="shortcut icon" href="images/electro_hogar_icono.ico" type="image/x-icon">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<x:set var="titulo" value="${msgtitulo}"> </x:set>
<x:set var="detalle" value="${msgdetalle}"> </x:set>
<body class="logincontainer" >
	<form class="login">
	<div >
	<center>
        <img src="images/electro_hogar_logo.jpg" style="max-height:100px;" >
        <br><label style='font-size:20px'>${titulo}</label>
    </center>
    <br>
    <div>
	<p>${detalle}</p>
	</div><br>
	
	<div style="text-align:right;font-size:12px;">
		<a href='cliente?opcion=seguimientoreclamo' title="Volver a la lista" class="azul" style="text-decoration:none;">Volver a la Lista</a><br><br>
    </div>
	</div>
	</form>
</body>
</html>