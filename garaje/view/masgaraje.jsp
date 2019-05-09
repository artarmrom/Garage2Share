<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
  <title>Garage2Share</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
 	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
	<link href="style/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="style/alertifyjs/css/alertify.css" rel="stylesheet" type="text/css" />
	<link href="style/alertifyjs/css/themes/default.css" rel="stylesheet" type="text/css" />
	<link href="style/checkbox.css" rel="stylesheet" type="text/css" />
	<link href="lstyle/loading.css" rel="stylesheet" type="text/css" />
	<script src="style/jquery-3.3.1.min.js"></script>
	<script src="style/bootstrap/js/bootstrap.js"></script>
	<script src="style/alertifyjs/alertify.js"></script>
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
     	padding: 30px;
     	margin: 10px;
     	margin-left: 100px;
        text-align: center;
  		position: relative;
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
		color:black;
		padding-top:15px;
		padding-bottom:15px;
		padding-left:15px;
		padding-right:15px;
		background-color:#b5f2f2;
		}
		
		  		h1,h2{
		  font-size:40px;
		  color:#0B618A;
		  }
		  
		        label, input{
		  color: #0B618A;
		  font-weight:bold;
		  text-align:center;
	  }
  </style>
</head>
<body>
<header>
	<nav>
		<ul>
			<li><a href="pantallaPrincipal.jsp">Inicio</a></li>
			<li><a href="AlquilerGaraje.jsp">Alquilar un garaje</a></li>
			<li><a href="ofrecerGaraje.jsp">Ofrecer un garaje</a></li>
			<li><a href="infoEmpresa.jsp">Información de la empresa</a></li>
			<li><a href="contactoEmpresa.jsp">Contacto</a></li>
			<li><a href="perfil.jsp">Perfil</a></li>
		</ul>
	</nav>
</header>
	<div class="header1" >
        <div class="text-center">
      		<h1><strong>Garage2Share</strong></h1>
    	 </div>
    </div>  
 <div class="Text">  
    <div>
        <div>
              <h2 class="text-center"><strong>
              	Estas a punto de reservar un garaje!
              </strong></h2>
        </div>
        <form action="/garaje/creacontrato" method="post">
        <div>
        Fecha inicial<%=request.getParameter("fecha_inicio")%>/05
        <p></p>
        Hora inicial<%=request.getParameter("hora_inicio") %>:00
        <div>
        Hora maxima<%=request.getParameter("fecha_fin")%>/05
        <p></p>
        Fecha maxima<%=request.getParameter("hora_fin") %>:00
        <p></p>
        Lugar<%=request.getParameter("lugar") %>
        <p></p>
        Direccion<%=request.getParameter("direccion") %>
        <p></p>
        Tipo de Vehiculo<%=request.getParameter("tipo") %>
        <p></p>
        Precio<%=request.getParameter("precio") %>
        <p></p>         
        <div>
			<label for="fecha_inicio">fecha inicial que desea</label>
            <input type="text" class="form-control"  id="horaini" name="horaini">
		</div>     
		<p></p>       
		 <div>
			<label for="hora_inicio">Hora inicial que desea</label>
            <input type="text" class="form-control"  id="horaini" name="horaini">
		</div>     
		<p></p>    
        <div>
			<label for="horas">Horas de estancia de su vehiculo:</label>
            <input type="text" class="form-control"  id="horas" name="horas">
		</div> 
		<br/>
		<button class="btn btn-info" type="submit"  id="alquila" name="alquila" >
			<span  class="glyphicon glyphicon-briefcase"></span> Alquila</button>

         </div>        
         </form> 
    </div>
  </div>
<div class="downText" >
    <div class="text-center">
        www.garage2share.com
    </div>
</div>			
</body>
</html>
