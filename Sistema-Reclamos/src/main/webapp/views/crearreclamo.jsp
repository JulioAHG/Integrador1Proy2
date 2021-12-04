<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Electro Hogar | Crear Reclamo</title>
</head>
<body>

<h1>Crear Reclamo</h1>

<form method="post" action="reclamo">
	<input type="hidden" name="opcion" value="guardar" />
	<label>Motivo de Contacto:</label>
	<select name="tipo" onchange="cambiar($(this).val())">
		<option value='Reclamo'>Reclamo</option>
		<option value='Queja'>Queja</option>
	</select>
	<label>Motivo de Reclamo / Queja:</label>
	<select name="subtipo" id="subtipo">
		<option value='Distinto al Precio Publicitario'>Distinto al Precio Publicitario</option>
		<option value='Producto Fallado'>Producto Fallado</option>
	</select>
	
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
 
	
	
	
	
	<label>Descripción del Incidente:</label>
	<textarea name="descripcion" ></textarea><br>
	
	<input type="submit" value="guardar" /><br>
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