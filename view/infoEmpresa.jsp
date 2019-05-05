<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
  <title>Garage2Share</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
  <style>
      .header1 
      {
      	font-size:150%;
        color: black;
        padding: 60px;
        text-align: center;
  		position: relative;
      }
      .Text 
      { 
     	border: 2px solid #b5f2f2;  /*borde: estilo y color*/
		font: normal normal 13px quicksand;  /*fuente*/
		color:black;  /*color de la fuente*/
		letter-spacing: 2px; /*separación entre las letras*/
		text-align: center; /*alineación del texto*/
		text-transform: uppercase; /*texto se transforma en mayúsculas*/
		padding: 6px;  /*tamaño del fondo*/
		border-radius: 30px 0px 30px 0px; /*ángulos de las 4 esquinas del borde/fondo*/
      }
      .downText 
      {
      	color: black;
      	text-align: center;
  		position: relative;
      }
      /*Eliminamos los margenes y paddings que agrega el navegador por defecto*/
		* {
		  padding: 0;
		  margin: 0;
		}
		 
		/*Agregamos margenes inferiores a los parrafos*/
		p {
		  margin-bottom: 20px;
		}
			
		header {
		  background: rgba(0,0,0,0.9);
		  width: 100%;
		  position: fixed;
		  z-index: 100;
		}
		nav {
		  float: left; /* Desplazamos el nav hacia la izquierda */
		}
		 
		nav ul {
		  list-style: none;
		  overflow: hidden; /* Limpiamos errores de float */
		}
		 
		nav ul li {
		  float: left;
		  font-family: Arial, sans-serif;
		  font-size: 16px;
		}
		 
		nav ul li a {
		  display: block; /* Convertimos los elementos a en elementos bloque para manipular el padding */
		  padding: 20px;
		  color: #fff;
		  text-decoration: none;
		}
		 
		nav ul li:hover {
		  background: #b5f2f2;
		}
		
		
		.boton {
			text-decoration:none;
			font-weight:600;
			font-size:20px;
			color:#ffffff;
			padding-top:15px;
			padding-bottom:15px;
			padding-left:15px;
			padding-right:15px;
			background-color:#3ead47;
		}
</style>
</head>
<body>
<header>
	<nav>
		<ul>
			<li><a href="pantallaPrincipal.html">Inicio</a></li>
			<li><a href="AlquilerGaraje.html">Alquilar un garaje</a></li>
			<li><a href="ofrecerGaraje.html">Ofrecer un garaje</a></li>
			<li><a href="infoEmpresa.html">Información de la empresa</a></li>
			<li><a href="contactoEmpresa.html">Contacto</a></li>
			<li><a href="perfil.html">Perfil</a></li>
		</ul>
	</nav>
</header>
	<div class="header1" >
        <div >
      		<h1>Garage2Share</h1>
    	 </div>
    </div>  
 <div class="Text">  
    <div>
        <div>
              <h2 class="text-center">
              	Garage2Share es una empresa fundada en Madrid y que se dedica a ofrecer alquileres 
              	de plazas de garaje tanto a interesados en alquilarlas como a interesados en ponerlas en alquiler.
              	Hasta el momento ofrecemos nuestros servicios en Madrid capital y en algunas ciudades más pequeñas del sur
              	de la capital como: Leganés, Villaverde, Getafe...
              </h2>
        </div>
     
    </div>
  </div>
<div class="downText" >
    <div class="text-center">
        www.garage2share.com
    </div>
</div>			
</body>
</html>