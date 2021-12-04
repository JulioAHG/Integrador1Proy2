<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Electro Hogar | Detalle de Reclamo</title>
</head>
<body>
<x:set var="reclamo" value="${reclamo}"> </x:set>
<x:set var="usuario" value="${usuario}"> </x:set>

<h1>Detalle de Reclamo</h1>

<label ><b>N° de Reclamo: ${reclamo.idReclamo}<b></label><br>
<label ><b>Fecha de Reclamo: ${reclamo.created_at}<b></label><br>

<label >Tipo: ${reclamo.tipo}</label><br>
<label >Sub Tipo: ${reclamo.subtipo}</label><br>
<label >Estado: <x:choose>
	<x:when test="${reclamo.estado=='0'}">
        PENDIENTE
    </x:when>
    <x:when test="${reclamo.estado=='1'}">
        ATENDIDO
    </x:when>    
    <x:otherwise>
        RECHAZADO
    </x:otherwise>
    </x:choose></label><br>
    
    <x:choose>
	<x:when test="${reclamo.tipo.equals("Reclamo")}">
         <fieldset>
	    	<legend>Detalle del Reclamo</legend>
	    	<label >Marca: ${reclamo.marcaProducto}</label><br>
	    	<label >Modelo : ${reclamo.modelo}</label><br>
	    	<label >Serie: ${reclamo.serie}</label><br>
	    	<label >Descripción: </label><br>
	    	${reclamo.descripcion}
	    </fieldset>
    </x:when>    
    <x:otherwise>
         <fieldset>
	    	<legend>Detalle de la Queja</legend>
	    	<label >Codigo de Empleado: ${reclamo.empleado}</label><br>
	    	<label >Local del Incidente : ${reclamo.local}</label><br>
	    	<label >Fecha de Incidente: ${reclamo.fechaincidente}</label><br>
	    	<label >Descripción: </label><br>
	    	${reclamo.descripcion}
	    </fieldset>
    </x:otherwise>
    </x:choose>
    <x:choose>
	<x:when test="${usuario.idCliente=='3'}">
		<x:choose>
		<x:when test="${reclamo.estado=='0'}">
			<form method="post" action="reclamo">
			<input type="hidden" name="opcion" value="accionreclamo" />
			<input type="hidden" name="idReclamo" value="${reclamo.idReclamo}" />
			<input type="hidden" name="estado" id="estado" value="1" />
	         <fieldset>
		    	<legend>Detalle de Atención</legend>
		    	<textarea name='descripcion'>
		    	</textarea>
		    	<input style="display:none;" id='procesar' type="submit" value="Procesar" /><br>
		    	<button type='button' onclick='cambiar(1)'>Aceptar Reclamo</button>
		    	<button type='button' onclick='cambiar(2)'>Rechazar Reclamo</button>
		    </fieldset>
			</form>
		</x:when> 
		<x:otherwise>
			<fieldset>
		    	<legend>Detalle de Atención</legend>
		    	<label >Fecha de Atención: ${reclamo.updated_at}</label><br>
		    	<label >Descripción: </label><br>
		    	${reclamo.atencion_detalle}
		    </fieldset>
		</x:otherwise>
		 </x:choose>
		 
		 <a href="reclamo?opcion=todosreclamos">Volver a la Lista</a>
    </x:when>    
    <x:otherwise>
         <fieldset>
	    	<legend>Detalle de Atención</legend>
	    	<label >Fecha de Atención: ${reclamo.updated_at}</label><br>
	    	<label >Descripción: </label><br>
	    	${reclamo.atencion_detalle}
	    </fieldset>
	    
	    <a href="reclamo?opcion=seguimientoreclamo">Volver a la Lista</a>
    </x:otherwise>
    </x:choose>
    
   <br>
   
    
   
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script>
   	function cambiar(valor){
   		$("#estado").val(valor);
   		document.getElementById('procesar').click();
   	}
   </script>
</body>
</html>