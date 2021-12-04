<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<header>
    <div class='menu-contenedor' id='pestanas_menu'>
        <% 
            Object[] datausuario = (Object[])session.getAttribute("sessionUsuario");
        %>
        
	<nav class="navegacion">
            <ul class="menu">
                <li id="m1"><a href="portada.jsp">Inicio</a></li>
                
                <x:choose>
					<x:when test="${cliente.idCliente=='3'}">
					<li id="m2">
	                    <a href='reclamo?opcion=todosreclamos'>Atender Reclamos</a>
	                </li>
	                <li id="m3">
	                    <a href='reclamo?opcion=seguimientoreclamo'>Reporte de Reclamos</a>        
	                </li>
	                 
				    </x:when>
				    <x:otherwise>
					    <li id="m2">
		                    <a href='cliente?opcion=registrarreclamo'>Registrar Reclamo</a>
		                </li>
				        <li id="m2">
		                    <a href='reclamo?opcion=seguimientoreclamo'>Seguimiento Reclamo</a>
		                </li>
				    </x:otherwise>
			    </x:choose>
    
                <li style='float:right;' id='menu_nouser'><a href="#"><i class='fas fa-user-circle'></i> &nbspBienvenido ${cliente.nombreCliente}</a>
                    <ul class="submenu">
                        
                    </ul>
                </li>
            </ul>
	</nav>
    </div>
</header>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>