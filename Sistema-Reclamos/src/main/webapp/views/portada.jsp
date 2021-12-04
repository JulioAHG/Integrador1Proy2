<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electro Hogar  | Bienvenido</title>
        <style>@import"css/estilos.css";</style>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <script src="https://use.fontawesome.com/d0255d9c7d.js"></script>
        <link rel="shortcut icon" href="images/electro_hogar_icono.ico" type="image/x-icon">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
        <body style='overflow:hidden;'>
         <jsp:include page="Header.jsp"/>
         
        <div style="background-color: white;text-align:center;width:50%;margin:80px auto;">
            <h3>Fecha: <label id="lblfecha"></label></h3>
            <div style="display: flex;justify-content:space-between;">
                
                <div style="width:35%">
                    <h4>Reclamos Generados</h4><br>
                    <div style="border:2px solid black;padding:15px;display:flex;justify-content: center;align-items: center;">
                        2
                    </div>
                </div>
                <div style="width:35%">
                    <h4>Reclamos Atendidos</h4><br>
                    <div style="border:2px solid black;padding:15px;display:flex;justify-content: center;align-items: center;">
                        4
                    </div>
                </div>
                <div style="width:20%">
                    <h4>% Atención</h4><br>
                    <div style="padding:15px;display:flex;justify-content: center;align-items: center;">
                        50%
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
    </body>
    
<script>
    window.onload = function() {
        var months = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];;
        var date = new Date();

        document.getElementById('lblfecha').innerHTML = months[date.getMonth()] + ' ' + date.getFullYear();
    };
    
    $("#m1").addClass("menu_selected");
    $("#m1 a").css("color", "#1766C1");
</script>
    
</html>