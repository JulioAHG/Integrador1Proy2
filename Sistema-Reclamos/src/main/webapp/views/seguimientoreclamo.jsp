<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electro Hogar  | Seguimiento Reclamo</title>
        <style>@import"css/estilos.css";</style>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <script src="https://use.fontawesome.com/d0255d9c7d.js"></script>
        <link rel="shortcut icon" href="images/electro_hogar_icono.ico" type="image/x-icon">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class='contenedor'>
<center><h3>Seguimiento Reclamo</h3></center>

<table>
<thead>
	<th>Tipo</th>
	<th>Sub Tipo</th>
	<th>Fecha de Creación</th>
	<th>Estado</th>
	<th>Acciones</th>
</thead>
<tbody>
	<x:forEach var="reclamo" items="${listareclamos}" >
	<tr>
	<td><x:out value="${reclamo.tipo}"></x:out></td>
	<td><x:out value="${reclamo.subtipo}"></x:out></td>
	<td><x:out value="${reclamo.created_at}"></x:out></td>
	<td>
	<x:choose>
	<x:when test="${reclamo.estado=='0'}">
        PENDIENTE
    </x:when>
    <x:when test="${reclamo.estado=='1'}">
        ATENDIDO
    </x:when>    
    <x:otherwise>
        RECHAZADO
    </x:otherwise>
    </x:choose>
	</td>
	<td><a href='reclamo?opcion=ver&id=${reclamo.idReclamo}'><center><i title='Ver Detalle' class="far fa-eye fa-lg"></i></center></a></td>
	</tr>
	</x:forEach>
</tbody>
</table>
</div>
<jsp:include page="Footer.jsp"/>
</body>
<script>
        $("#m3").addClass("menu_selected");
        $("#m3 a input").css("color", "#1766C1");
        
        function preguntar(cont){
            Swal.fire({
                title: '¿Deseas eliminar el Reclamo?',
                text: "Si eliminas el reclamo no podrás recuperarlo!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Continuar',
                cancelButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire(
                      'Eliminado!',
                      'El reclamo se eliminó con éxito',
                      'success'
                    ).then(function() {
                        $("#"+cont).click();
                    });

                        
                    
                }
            });
        }
    </script>
</html>