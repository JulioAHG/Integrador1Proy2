<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="x" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electro Hogar  | Login</title>
        <style>@import"../css/estilos.css";</style>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <script src="https://use.fontawesome.com/d0255d9c7d.js"></script>
        <link rel="shortcut icon" href="../images/electro_hogar_icono.ico" type="image/x-icon">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body class="logincontainer">



<form method='post' action='cliente' class="login">
			<div>
                <center>
                    <img src="../images/electro_hogar_logo.jpg" style="max-height:100px;" >
                    <br><label style='font-size:20px'>Inicio de Sesión</label>
                </center>
                <br>
                <x:set var="msg" value="${msglogin}"> </x:set>
				<h3>${msg}</h3>
                
                <br>
                <div >
                <div style="text-align:left;">Ingresa Usuario</div><br>
                <input type="text" name="usuario" id="usuario" class="input"/><br>
                <label id="lbluser" style="color:red;font-size:11px;"></label>    
                </div>
                
                <br><div style="text-align:left;">Ingresa Contraseña</div><br>
                <input type="password" name="contrasenia" id="password" class="input" /><br>
                <label id="lblpass" style="color:red;font-size:11px;"></label>
                <br>
                <div style="text-align:right;font-size:12px;">
                    <a href='http://localhost:8080/Sistema-Reclamos/cliente?opcion=crear' title="Registrar Empleado" class="azul" style="text-decoration:none;">Registrar Cuenta</a><br><br>
                    <a href='http://localhost:8080/Sistema-Reclamos/cliente?opcion=recuperar' title="Recuperar Cuenta" class="azul" style="text-decoration:none;">¿Olvidó su contraseña?</a>
                </div>
                
                <br><br>
                
                <button type='button' class="btn_success" onclick="validar()" >Iniciar Sesión</button>
                <!--<button type='button'><a href="Portada.jsp" style='text-decoration: none;color:white;'>Ingresar</a></button>-->
                <input value="ingresar" id="ingresar" styleClass="boton_nuevo" style='display:none;' />
            </div>
            
</form>

		<script>
            function validar(){
                $("#lbluser").html("");$("#lblpass").html("");
                if($("#usuario").val()===""){
                    $("#lbluser").html("Debes ingresar un usuario");return false;
                }
                if($("#password").val()===""){
                    $("#lblpass").html("Debes ingresar una constraseña");return false;
                }    
                $("#ingresar").click();
            }
        </script>
    </body>
</html>
