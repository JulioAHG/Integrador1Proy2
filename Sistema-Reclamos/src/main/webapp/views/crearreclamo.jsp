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
<jsp:include page="Header.jsp"/>
<div class='contenedor'>
<center><h3>Registrar Reclamo</h3></center>


<form method="post" action="reclamo" class="formulario_registro" style="width:70%;">
	<input type="hidden" name="opcion" value="guardar" />
	<div style="display:flex;justify-content: space-between">
    	<div class="parts">
    	<label>Motivo de Contacto</label>
    	<select name="tipo" onchange="cambiar($(this).val())">
			<option value='Reclamo'>Reclamo</option>
			<option value='Queja'>Queja</option>
		</select>
    	</div>
    	<div class="parts">
			<label>Motivo de Reclamo / Queja</label>
			<select name="subtipo" id="subtipo">
				<option value='Distinto al Precio Publicitario'>Distinto al Precio Publicitario</option>
				<option value='Producto Fallado'>Producto Fallado</option>
			</select>
		</div>
    </div>
	
	 <fieldset id="reclamo">
	  <legend>Detalles del Reclamo</legend>
	  <label>Marca del producto:</label>
		<input type="text" name="marcaProducto" /><br>
		<label>Modelo del Producto (opcional):</label>
		<input type="text" name="modelo" /><br>
		<label>Número de Serie:</label>
		<input type="text" name="serie" /><br>
		
	 </fieldset>
	 
	 <fieldset id="queja">
	  <legend>Detalles de la Queja</legend>
	  <label>Codigo de Personal:</label>
		<input type="text" name="empleado" /><br>
		<label>Local del Incidente:</label>
		<input type="text" name="local" /><br>
		<label>Fecha y Hora de Incidente (opcional):</label>
		<input type="datetime-local" name="fechaincidente" /><br>
	
	 </fieldset>
 
	
	
	
	<br>
	<label>Descripción del Incidente:</label>
	<textarea name="descripcion" style="width:90%;" ></textarea><br>
	
	<input type="submit" class="boton_nuevo" value="guardar" /><br>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$("#queja").hide();
function cambiar(valor){
	
	if(valor=="Queja"){
		$("#subtipo").html(`<option value='Mala Atencion'>Mala Atencion</option>`);
		$("#queja").show();
		$("#reclamo").hide();
	}else{
		$("#subtipo").html(`<option value='Distinto al Precio Publicitario'>Distinto al Precio Publicitario</option>
				<option value='Producto Fallado'>Producto Fallado</option>`);
		$("#queja").hide();
		$("#reclamo").show();
	}
}
</script>
</body>
</html>