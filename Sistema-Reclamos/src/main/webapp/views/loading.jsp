<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electro Hogar</title>
        <style>@import"css/estilos.css";</style>
        <link rel="shortcut icon" href="images/electro_hogar_icono.ico" type="image/x-icon">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <script src="https://use.fontawesome.com/d0255d9c7d.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <style>
            #container {
                margin: 20px;
                width: 400px;
                height: 15px;
            }
        </style>
    </head>
    <body style="display:flex;justify-content: center;align-items: center;">
        <div class="loading">
            <img src="images/electro_hogar_logo.jpg">
            <div id="container"></div>    
        </div>
    </body>
</html>

<script src="js/progressbar.min.js"></script>
<script src="js/progressbar.js"></script>

<script>
    var bar = new ProgressBar.Line(container, {
  strokeWidth: 4,
  easing: 'easeInOut',
  duration: 5000,
  color: '#FFEA82',
  trailColor: '#eee',
  trailWidth: 1,
  svgStyle: {width: '100%', height: '100%'},
  from: {color: '#A3AEB7'},
  to: {color: '#3187D3'},
  step: (state, bar) => {
    bar.path.setAttribute('stroke', state.color);
  }
});

bar.animate(1.0);  // Number from 0.0 to 1.0

    setTimeout(function(){
        window.location.href = "http://localhost:8080/Sistema-Reclamos/views/login.jsp";
    },5000);

</script>